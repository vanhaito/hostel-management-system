import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddNhanVienQlComponent } from 'src/app/dialog/add-nhan-vien-ql/add-nhan-vien-ql.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { KyTucXaService } from 'src/service/ky-tuc-xa.service';
import { NguoiService } from 'src/service/nguoi.service';
import { NhanVienQlService } from 'src/service/nhan-vien-ql.service';

@Component({
  selector: 'app-nhan-vien-quan-ly',
  templateUrl: './nhan-vien-quan-ly.component.html',
  styleUrls: ['./nhan-vien-quan-ly.component.scss']
})
export class NhanVienQuanLyComponent implements OnInit {


  resultComfirm: string = '';
  formSearch!: FormGroup;

  nhanVienQlList: any[] = [];
  nguoiList: any[] = [];
  kyTucXaList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maSoDinhDanhN",
    "trinhDo",
    "tenKyTucXa",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private nhanVienQlService: NhanVienQlService,
    private nguoiService: NguoiService,
    private kyTucXaService: KyTucXaService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.getListNguoiAndKtx();
  }


  getAll(): void {
    this.nhanVienQlService.getAll().subscribe((data) => {
      console.log(data);
      this.nhanVienQlList = data;
      console.log(this.nhanVienQlList);
      this.dataSource = new MatTableDataSource<any>(this.nhanVienQlList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(nhanVienQl: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.nhanVienQlService.deleteNhanVienQl(nhanVienQl.maSoDinhDanhN).subscribe(
          (data) => {
            this.openSnackBar('Xóa thành công');
            this.getAll();
          },
          (error) => {
            this.openSnackBar('Xóa thất bại');
          }
        );
      }
    });
  }

  getListNguoiAndKtx(){
    this.nguoiService.getAll().subscribe((data) => {
      console.log(data);
      this.nguoiList = data;
      console.log(this.nguoiList);
    });

    this.kyTucXaService.getAll().subscribe((data) => {
      this.kyTucXaList = data;
      console.log(this.kyTucXaList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddNhanVienQlComponent, {
      data:{
        update: false,
        nhanVienQl: new Object(),
        nguoiList: this.nguoiList,
        kyTucXaList: this.kyTucXaList,
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.nhanVienQlService.createNhanVienQl(result).subscribe(
          (data) => {
            this.openSnackBar('Thêm thành công');
            this.getAll();
          },
          (error) => {
            console.log(error)
        var mess = '';
        if (error.message) {
          var log = error.message;
          this.openSnackBar('Thêm thất bại: \n' + log);
        } else this.openSnackBar('Thêm thất bại: '+ error.status ? error.status:"");
          }
        );
      }
    });
  }

  openEditDialog(data?: any) {
    // console.log(data)
    const dialogRef = this.dialog.open(AddNhanVienQlComponent, {
      data: {
        update: true,
        nhanVienQl: Object.assign(new Object(),data),
        nguoiList: this.nguoiList,
        kyTucXaList: this.kyTucXaList,
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.nhanVienQlService.update(result, result.maSoDinhDanhN).subscribe(
          (data) => {
            this.openSnackBar('cập nhật thành công');
            this.getAll();
          },
          (error) => {
            console.log(error)
        if (error.error.message) {
          var log = error.error.message;
          this.openSnackBar('Cập nhật thất bại: \n' + log);
        } else this.openSnackBar('Cập nhật thất bại: '+ error.error.status ? error.error.status:"");
          }
        );
      }
    });
  }

  openSnackBar(content: any) {
    this._snackBar.open(content, 'OK', {
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }

}
