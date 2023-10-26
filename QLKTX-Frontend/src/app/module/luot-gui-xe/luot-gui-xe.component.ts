import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddLuotGuiXeComponent } from 'src/app/dialog/add-luot-gui-xe/add-luot-gui-xe.component';
import { AddVeXeComponent } from 'src/app/dialog/add-ve-xe/add-ve-xe.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { LuotGuiXeService } from 'src/service/luot-gui-xe.service';
import { SinhVienService } from 'src/service/sinh-vien.service';
import { VeXeService } from 'src/service/ve-xe.service';

@Component({
  selector: 'app-luot-gui-xe',
  templateUrl: './luot-gui-xe.component.html',
  styleUrls: ['./luot-gui-xe.component.scss']
})
export class LuotGuiXeComponent implements OnInit {
  resultComfirm: string = '';
  formSearch!: FormGroup;

  luotGuiXeList: any[] = [];
  sinhVienList: any[] = [];
  veXeList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maLanGui",
    "thoiGianGui",
    "thoiGianLay",
    "bienSoXe",
    // "maSv",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private luotGuiXeService: LuotGuiXeService,
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
    this.luotGuiXeService.getAll().subscribe((data) => {
      console.log(data);
      this.luotGuiXeList = data;
      console.log(this.luotGuiXeList);
      this.dataSource = new MatTableDataSource<any>(this.luotGuiXeList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(luotGuiXe: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.luotGuiXeService.deleteLanGuiXe(luotGuiXe.maLanGui).subscribe(
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

    this.veXeService.getAll().subscribe((data) => {
      console.log(data);
      this.veXeList = data;
      console.log(this.veXeList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddLuotGuiXeComponent, {
      data:{
        update: false,
        luotGuiXe: new Object(),
        sinhVienList: this.sinhVienList,
        veXeList: this.veXeList,
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.luotGuiXeService.createLanGuiXe(result).subscribe(
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
    const dialogRef = this.dialog.open(AddLuotGuiXeComponent, {
      data: {
        update: true,
        luotGuiXe: Object.assign(new Object(),data),
        sinhVienList: this.sinhVienList,
        veXeList: this.veXeList,
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.luotGuiXeService.update(result, result.maLanGui).subscribe(
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
