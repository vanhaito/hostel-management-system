import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddVeXeComponent } from 'src/app/dialog/add-ve-xe/add-ve-xe.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { SinhVienService } from 'src/service/sinh-vien.service';
import { VeXeService } from 'src/service/ve-xe.service';

@Component({
  selector: 'app-ve-xe',
  templateUrl: './ve-xe.component.html',
  styleUrls: ['./ve-xe.component.scss']
})
export class VeXeComponent implements OnInit {

  resultComfirm: string = '';
  formSearch!: FormGroup;

  veXeList: any[] = [];
  sinhVienList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "bienSoXe",
    "loaiXe",
    "mauXe",
    "trangThai",
    "maSv",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private veXeService: VeXeService,
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
    this.veXeService.getAll().subscribe((data) => {
      console.log(data);
      this.veXeList = data;
      console.log(this.veXeList);
      this.dataSource = new MatTableDataSource<any>(this.veXeList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(veXe: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.veXeService.deleteVeXe(veXe.bienSoXe).subscribe(
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
    this.sinhVienService.getAll().subscribe((data) => {
      console.log(data);
      this.sinhVienList = data;
      console.log(this.sinhVienList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddVeXeComponent, {
      data:{
        update: false,
        veXe: new Object(),
        sinhVienList: this.sinhVienList
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.veXeService.createVeXe(result).subscribe(
          (data) => {
            this.openSnackBar('Thêm thành công');
            this.getAll();
          },
          (error) => {
            console.log(error)
        var mess = '';
        if (error.error.message) {
          var log = error.error.message;
          this.openSnackBar('Thêm thất bại: \n' + log);
        } else this.openSnackBar('Thêm thất bại: '+ error.status ? error.status:"");
          }
        );
      }
    });
  }

  openEditDialog(data?: any) {
    // console.log(data)
    const dialogRef = this.dialog.open(AddVeXeComponent, {
      data: {
        update: true,
        veXe: Object.assign(new Object(),data),
        sinhVienList: this.sinhVienList
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.veXeService.update(result, result.bienSoXe).subscribe(
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
