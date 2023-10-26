import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddLuotThamComponent } from 'src/app/dialog/add-luot-tham/add-luot-tham.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { KhachService } from 'src/service/khach.service';
import { LuotThamService } from 'src/service/luot-tham.service';
import { NguoiService } from 'src/service/nguoi.service';
import { SinhVienService } from 'src/service/sinh-vien.service';

@Component({
  selector: 'app-luot-tham',
  templateUrl: './luot-tham.component.html',
  styleUrls: ['./luot-tham.component.scss']
})
export class LuotThamComponent implements OnInit {


  resultComfirm: string = '';
  formSearch!: FormGroup;

  luotThamList: any[] = [];
  khachList: any[] = [];
  sinhVienList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maLuotTham",
    "maSoDinhDanhK",
    "thoiGianDen",
    "thoiGianDi",
    "maSv",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private luotThamService: LuotThamService,
    private sinhVienService: SinhVienService,
    private nguoiService: NguoiService,
    private khachService: KhachService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.getListNguoiAndSV();
  }


  getAll(): void {
    this.luotThamService.getAll().subscribe((data) => {
      console.log(data);
      this.luotThamList = data;
      console.log(this.luotThamList);
      this.dataSource = new MatTableDataSource<any>(this.luotThamList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(luotTham: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.luotThamService.deleteLuotTham(luotTham.maLuotTham).subscribe(
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

  getListNguoiAndSV(){
    this.khachService.getAll().subscribe((data) => {
      console.log(data);
      this.khachList = data;
      console.log(this.khachList);
    });

    this.sinhVienService.getAllDaKyHD().subscribe((data) => {
      console.log(data);
      this.sinhVienList = data;
      console.log(this.sinhVienList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddLuotThamComponent, {
      data:{
        update: false,
        luotTham: new Object(),
        khachList: this.khachList,
        sinhVienList: this.sinhVienList
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.luotThamService.createLuotTham(result).subscribe(
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
    const dialogRef = this.dialog.open(AddLuotThamComponent, {
      data: {
        update: true,
        luotTham: Object.assign(new Object(),data),
        khachList: this.khachList,
        sinhVienList: this.sinhVienList
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.luotThamService.update(result, result.maLuotTham).subscribe(
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
