import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddGiatLaComponent } from 'src/app/dialog/add-giat-la/add-giat-la.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { GiatLaService } from 'src/service/giat-la.service';
import { SinhVienService } from 'src/service/sinh-vien.service';

@Component({
  selector: 'app-giat-la',
  templateUrl: './giat-la.component.html',
  styleUrls: ['./giat-la.component.scss']
})
export class GiatLaComponent implements OnInit {

  resultComfirm: string = '';
  formSearch!: FormGroup;

  giatLaList: any[] = [];
  sinhVienList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maLuotGiat",
    "donGia",
    "khoiLuong",
    "ngayGiat",
    "maSv",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private giatLaService: GiatLaService,
    private sinhVienService: SinhVienService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.getListSinhVien();
  }


  getAll(): void {
    this.giatLaService.getAll().subscribe((data) => {
      console.log(data);
      this.giatLaList = data;
      console.log(this.giatLaList);
      this.dataSource = new MatTableDataSource<any>(this.giatLaList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(giatLa: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.giatLaService.deleteLanGiat(giatLa.maLuotGiat).subscribe(
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

  getListSinhVien(){
    this.sinhVienService.getAllDaKyHD().subscribe((data) => {
      console.log(data);
      this.sinhVienList = data;
      console.log(this.sinhVienList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddGiatLaComponent, {
      data:{
        update: false,
        giatLa: new Object(),
        sinhVienList: this.sinhVienList
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.giatLaService.createLanGiat(result).subscribe(
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
    const dialogRef = this.dialog.open(AddGiatLaComponent, {
      data: {
        update: true,
        giatLa: Object.assign(new Object(),data),
        sinhVienList: this.sinhVienList
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.giatLaService.update(result, result.maLuotGiat).subscribe(
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
