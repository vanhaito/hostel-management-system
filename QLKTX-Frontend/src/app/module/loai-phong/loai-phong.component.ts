import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddLoaiPhongComponent } from 'src/app/dialog/add-loai-phong/add-loai-phong.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { LoaiPhongService } from 'src/service/loai-phong.service';

@Component({
  selector: 'app-loai-phong',
  templateUrl: './loai-phong.component.html',
  styleUrls: ['./loai-phong.component.scss']
})
export class LoaiPhongComponent implements OnInit {


  resultComfirm: string = '';
  formSearch!: FormGroup;

  loaiPhongList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maLoaiPhong",
    "tenLoaiPhong",
    "dienTich",
    "gia",
    "soSvToiDa",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private loaiPhongService: LoaiPhongService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
  }


  getAll(): void {
    this.loaiPhongService.getAll().subscribe((data) => {
      console.log(data);
      this.loaiPhongList = data;
      console.log(this.loaiPhongList);
      this.dataSource = new MatTableDataSource<any>(this.loaiPhongList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(loaiPhong: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.loaiPhongService.deleteLoaiPhong(loaiPhong.maSoDinhDanhS).subscribe(
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
    const dialogRef = this.dialog.open(AddLoaiPhongComponent, {
      data:{
        update: false,
        loaiPhong: new Object()
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.loaiPhongService.createLoaiPhong(result).subscribe(
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
    const dialogRef = this.dialog.open(AddLoaiPhongComponent, {
      data: {
        update: true,
        loaiPhong: Object.assign(new Object(),data)
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.loaiPhongService.update(result, result.maSoDinhDanhS).subscribe(
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
