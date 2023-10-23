import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-hoa-don-dien-nuoc',
  templateUrl: './add-hoa-don-dien-nuoc.component.html',
  styleUrls: ['./add-hoa-don-dien-nuoc.component.scss'],
})
export class AddHoaDonDienNuocComponent implements OnInit {
  formControl!: FormGroup;

  phong: any = {};

  constructor(
    public dialogRef: MatDialogRef<AddHoaDonDienNuocComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {
    this.makeForm();
    // this.formControl.setValue(this.data);

    this.phong = this.data.phongList.find((e: any) => {
      return e.tenPhong == this.data.hoaDonDienNuoc.tenPhong &&
        e.tenKyTucXa == this.data.hoaDonDienNuoc.tenKtx
    });
    console.log(this.phong)
    this.formControl.controls['phong'].setValue(this.phong.tenKyTucXa - this.phong.tenPhong);
  }

  makeForm() {
    this.formControl = new FormGroup({
      maHoaDon: new FormControl(''),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      ngayLapHoaDon: new FormControl('', Validators.required),
      chiSoDienDau: new FormControl('', Validators.required),
      chiSoDienCuoi: new FormControl('', Validators.required),
      chiSoNuocDau: new FormControl('', Validators.required),
      chiSoNuocCuoi: new FormControl('', Validators.required),
      donGiaDien: new FormControl('', Validators.required),
      donGiaNuoc: new FormControl('', Validators.required),
      ngayBatDau: new FormControl('', Validators.required),
      ngayKetThuc: new FormControl('', Validators.required),
      phong: new FormControl('', Validators.required),
    });
  }

  edit(): void {
    var addData : any = {};
    Object.assign(addData, this.formControl.value);
    addData.tenPhong = this.phong.tenPhong;
    addData.tenKtx = this.phong.tenKyTucXa;
    this.dialogRef.close(addData);
  }
}
