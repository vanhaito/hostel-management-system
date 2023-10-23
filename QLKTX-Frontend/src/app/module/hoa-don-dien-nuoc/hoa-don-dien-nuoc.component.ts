import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddHoaDonDienNuocComponent } from 'src/app/dialog/add-hoa-don-dien-nuoc/add-hoa-don-dien-nuoc.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { HoaDonDienNuocService } from 'src/service/hoa-don-dien-nuoc.service';
import { KyTucXaService } from 'src/service/ky-tuc-xa.service';
import { NguoiService } from 'src/service/nguoi.service';
import { PhongService } from 'src/service/phong.service';
import { SinhVienService } from 'src/service/sinh-vien.service';

@Component({
  selector: 'app-hoa-don-dien-nuoc',
  templateUrl: './hoa-don-dien-nuoc.component.html',
  styleUrls: ['./hoa-don-dien-nuoc.component.scss']
})
export class HoaDonDienNuocComponent implements OnInit {

  resultComfirm: string = '';
  formSearch!: FormGroup;

  hoaDonDienNuocList: any[] = [];
  nguoiList: any[] = [];
  kyTucXaList: any[] = [];
  phongList: any[] = [];
  sinhVienList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maHoaDon",
    "ngayLapHoaDon",
    "chiSoDienDau",
    "chiSoDienCuoi",
    "chiSoNuocDau",
    "chiSoNuocCuoi",
    "donGiaDien",
    "donGiaNuoc",
    "ngayBatDau",
    "ngayKetThuc",
    "tenKtx",
    "tenPhong",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private hoaDonDienNuocService: HoaDonDienNuocService,
    private nguoiService: NguoiService,
    private kyTucXaService: KyTucXaService,
    private phongService: PhongService,
    private sinhVienService: SinhVienService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
    this.getListNguoiAndKtxAndPhongAndSinhVien();
  }


  getAll(): void {
    this.hoaDonDienNuocService.getAll().subscribe((data) => {
      console.log(data);
      this.hoaDonDienNuocList = data;
      console.log(this.hoaDonDienNuocList);
      this.dataSource = new MatTableDataSource<any>(this.hoaDonDienNuocList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(hoaDonDienNuoc: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.hoaDonDienNuocService.deleteHoaDonDienNuoc(hoaDonDienNuoc.maHoaDon).subscribe(
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

  getListNguoiAndKtxAndPhongAndSinhVien(){
    this.nguoiService.getAll().subscribe((data) => {
      console.log(data);
      this.nguoiList = data;
      console.log(this.nguoiList);
    });

    this.kyTucXaService.getAll().subscribe((data) => {
      this.kyTucXaList = data;
      console.log(this.kyTucXaList);
    });

    this.sinhVienService.getAll().subscribe((data) => {
      this.sinhVienList = data;
      console.log(this.kyTucXaList);
    });

    this.phongService.getAll().subscribe((data) => {
      this.phongList = data;
      console.log(this.kyTucXaList);
    });
  }

  openAddDialog() {
    const dialogRef = this.dialog.open(AddHoaDonDienNuocComponent, {
      data:{
        update: false,
        hoaDonDienNuoc: new Object(),
        nguoiList: this.nguoiList,
        kyTucXaList: this.kyTucXaList,
        sinhVienList: this.sinhVienList,
        phongList: this.phongList
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.hoaDonDienNuocService.createHoaDonDienNuoc(result).subscribe(
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
    const dialogRef = this.dialog.open(AddHoaDonDienNuocComponent, {
      data: {
        update: true,
        hoaDonDienNuoc: Object.assign(new Object(),data),
        nguoiList: this.nguoiList,
        kyTucXaList: this.kyTucXaList,
        sinhVienList: this.sinhVienList,
        phongList: this.phongList
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.hoaDonDienNuocService.update(result, result.maHoaDon).subscribe(
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
