import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddPhongComponent } from 'src/app/dialog/add-phong/add-phong.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { KyTucXaService } from 'src/service/ky-tuc-xa.service';
import { LoaiPhongService } from 'src/service/loai-phong.service';
import { PhongService } from 'src/service/phong.service';

@Component({
  selector: 'app-phong',
  templateUrl: './phong.component.html',
  styleUrls: ['./phong.component.scss']
})
export class PhongComponent implements OnInit {

  resultComfirm: string = '';
  formSearch!: FormGroup;

  phongList: any[] = [];
  loaiPhongList: any[] = [];
  kyTucXaList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "tenKyTucXa",
    "tenPhong",
    "soSvHienCo",
    "tang",
    "maLoaiPhong",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private phongService: PhongService,
    private loaiPhongService: LoaiPhongService,
    private kyTucXaService: KyTucXaService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.getListLoaiPhongAndKyTucXa();
  }


  getAll(): void {
    this.phongService.getAll().subscribe((data) => {
      console.log(data);
      this.phongList = data;
      console.log(this.phongList);
      this.dataSource = new MatTableDataSource<any>(this.phongList);
      // this.dataSource.paginator = this.paginator;
    });
  }

  getListLoaiPhongAndKyTucXa(){
    this.loaiPhongService.getAll().subscribe((data) => {
      this.loaiPhongList = data;
      console.log(this.loaiPhongList);
    });

    this.kyTucXaService.getAll().subscribe((data) => {
      this.kyTucXaList = data;
      console.log(this.kyTucXaList);
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
        this.phongService.deletePhong(data.tenKyTucXa, data.tenPhong).subscribe(
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
    const dialogRef = this.dialog.open(AddPhongComponent, {
      data:{
        update: false,
        phong: new Object(),
        loaiPhongList: this.loaiPhongList,
        kyTucXaList: this.kyTucXaList
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.phongService.createPhong(result).subscribe(
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
    const dialogRef = this.dialog.open(AddPhongComponent, {
      data: {
        update: true,
        phong: Object.assign(new Object(),data),
        loaiPhongList: this.loaiPhongList,
        kyTucXaList: this.kyTucXaList
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.phongService.update(result, result.tenKyTucXa, result.tenPhong).subscribe(
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
