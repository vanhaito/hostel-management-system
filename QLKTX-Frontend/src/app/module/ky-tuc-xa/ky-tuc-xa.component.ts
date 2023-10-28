import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { AddKyTucXaComponent } from 'src/app/dialog/add-ky-tuc-xa/add-ky-tuc-xa.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { KyTucXaService } from 'src/service/ky-tuc-xa.service';

@Component({
  selector: 'app-ky-tuc-xa',
  templateUrl: './ky-tuc-xa.component.html',
  styleUrls: ['./ky-tuc-xa.component.scss']
})
export class KyTucXaComponent implements OnInit {


  resultComfirm: string = '';
  formSearch!: FormGroup;

  kyTucXaList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "tenKyTucXa",
    "soLuongPhong",
    "diaChi",
    "action"
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private kyTucXaService: KyTucXaService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.getAll();
  }


  getAll(): void {
    this.kyTucXaService.getAll().subscribe((data) => {
      console.log(data);
      this.kyTucXaList = data;
      console.log(this.kyTucXaList);
      this.dataSource = new MatTableDataSource<any>(this.kyTucXaList);
      // this.dataSource.paginator = this.paginator;
    });
  }


  // confirm delete

  confirmDialog(kyTucXa: any): void {
    const message = `Are you sure you want to do this?`;

    const dialogData = new ConfirmDialogModel('Confirm Action', message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      maxWidth: '600px',
      data: dialogData,
    });

    dialogRef.afterClosed().subscribe((dialogResult) => {
      if (dialogResult == true) {
        console.log('delete');
        this.kyTucXaService.deleteKyTucXa(kyTucXa.tenKyTucXa).subscribe(
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
    const dialogRef = this.dialog.open(AddKyTucXaComponent, {
      data:{
        update: false,
        kyTucXa: new Object()
      }});

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.kyTucXaService.createKyTucXa(result).subscribe(
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
    const dialogRef = this.dialog.open(AddKyTucXaComponent, {
      data: {
        update: true,
        kyTucXa: Object.assign(new Object(),data)
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        console.log(result);
        this.kyTucXaService.update(result, result.tenKyTucXa).subscribe(
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
