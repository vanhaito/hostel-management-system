import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-hop-dong',
  templateUrl: './add-hop-dong.component.html',
  styleUrls: ['./add-hop-dong.component.scss']
})
export class AddHopDongComponent implements OnInit {

  formControl!: FormGroup ;
  phong: any = {};

  constructor(
    public dialogRef: MatDialogRef<AddHopDongComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
    this.phong = this.data.phongList.find((e: any) => {
      return e.tenPhong == this.data.hopDong.tenPhong &&
        e.tenKyTucXa == this.data.hopDong.tenKtx
    });
    console.log(this.phong)
    this.formControl.controls['phong'].setValue(this.phong.tenKyTucXa - this.phong.tenPhong);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maHopDong":  new FormControl(''),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "ngayBatDau": new FormControl('',Validators.required),
      "ngayKetThuc": new FormControl('',Validators.required),
      "maSv": new FormControl('',Validators.required),
      "maSoDinhDanhN": new FormControl('',Validators.required),
      // "tenPhong": new FormControl('',Validators.required),
      "phong": new FormControl('', Validators.required),
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
