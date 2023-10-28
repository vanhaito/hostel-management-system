import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddNguoiSdtComponent } from 'src/app/dialog/add-nguoi-sdt/add-nguoi-sdt.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { NguoiSdtService } from 'src/service/nguoi-sdt.service';
import { NguoiService } from 'src/service/nguoi.service';

@Component({
  selector: 'app-nguoi-sdt',
  templateUrl: './nguoi-sdt.component.html',
  styleUrls: ['./nguoi-sdt.component.scss']
})
export class NguoiSdtComponent implements OnInit {


  resultComfirm: string = '';
  formSearch!: FormGroup;

  nguoiSdtList: any[] = [];
  nguoiList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maSoDinhDanh",
    "soDienThoai",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private nguoiSdtService: NguoiSdtService,
    private nguoiService: NguoiService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
  }

  getListNguoi(){
    this.nguoiService.getAll().subscribe((data) => {
      console.log(data);
      this.nguoiList = data;
      console.log(this.nguoiList);
    });
  }


  getAll(): void {
    this.nguoiSdtService.getAll().subscribe((data) => {
      console.log(data);
      this.nguoiSdtList = data;
      console.log(this.nguoiSdtList);
      this.dataSource = new MatTableDataSource<any>(this.nguoiSdtList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(data: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.nguoiSdtService.delete(data.maSoDinhDanh, data.soDienThoai).subscribe(
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

  openAddDialog() {
    const dialogRef = this.dialog.open(AddNguoiSdtComponent, {
      data:{
        update: false,
        nguoiList: this.nguoiList,
        nguoiSdt: new Object()
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.nguoiSdtService.create(result).subscribe(
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
    const dialogRef = this.dialog.open(AddNguoiSdtComponent, {
      data: {
        update: true,
        nguoiList: this.nguoiList,
        nguoiSdt: Object.assign(new Object(),data)
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.nguoiSdtService.update(result, result.maSoDinhDanh, result.soDienThoai).subscribe(
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
