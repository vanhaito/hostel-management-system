import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-giat-la',
  templateUrl: './add-giat-la.component.html',
  styleUrls: ['./add-giat-la.component.scss']
})
export class AddGiatLaComponent implements OnInit {

  formControl!: FormGroup ;
  dateTime: any;

  constructor(
    public dialogRef: MatDialogRef<AddGiatLaComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {
    this.dateTime = new Date(this.data.giatLa.ngayGiat) ?? new Date();
    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maLuotGiat":  new FormControl(''),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "donGia": new FormControl('',Validators.required),
      "khoiLuong": new FormControl('',Validators.required),
      "ngayGiat": new FormControl('',Validators.required),
      "maSv": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}
}
