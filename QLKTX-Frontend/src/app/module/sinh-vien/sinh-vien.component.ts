import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddSinhVienComponent } from 'src/app/dialog/add-sinh-vien/add-sinh-vien.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { NguoiService } from 'src/service/nguoi.service';
import { SinhVienService } from 'src/service/sinh-vien.service';

@Component({
  selector: 'app-sinh-vien',
  templateUrl: './sinh-vien.component.html',
  styleUrls: ['./sinh-vien.component.scss']
})
export class SinhVienComponent implements OnInit {


  resultComfirm: string = '';
  formSearch!: FormGroup;

  sinhVienList: any[] = [];
  nguoiList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maSoDinhDanhS",
    "maSv",
    "lop",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private sinhVienService: SinhVienService,
    private nguoiService: NguoiService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.getListNguoi();
  }


  getAll(): void {
    this.sinhVienService.getAll().subscribe((data) => {
      console.log(data);
      this.sinhVienList = data;
      console.log(this.sinhVienList);
      this.dataSource = new MatTableDataSource<any>(this.sinhVienList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(sinhVien: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.sinhVienService.deleteSinhVien(sinhVien.maSv).subscribe(
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

  getListNguoi(){
    this.nguoiService.getAll().subscribe((data) => {
      console.log(data);
      this.nguoiList = data;
      console.log(this.nguoiList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddSinhVienComponent, {
      data:{
        update: false,
        sinhVien: new Object(),
        nguoiList: this.nguoiList
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.sinhVienService.createSinhVien(result).subscribe(
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
    const dialogRef = this.dialog.open(AddSinhVienComponent, {
      data: {
        update: true,
        sinhVien: Object.assign(new Object(),data),
        nguoiList: this.nguoiList
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.sinhVienService.update(result, result.maSv).subscribe(
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
