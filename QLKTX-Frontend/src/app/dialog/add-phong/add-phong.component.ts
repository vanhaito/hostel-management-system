import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-phong',
  templateUrl: './add-phong.component.html',
  styleUrls: ['./add-phong.component.scss']
})
export class AddPhongComponent implements OnInit {
  formControl!: FormGroup ;

  constructor(
    public dialogRef: MatDialogRef<AddPhongComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "tenKyTucXa":  new FormControl('',Validators.required),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "tenPhong": new FormControl('',Validators.required),
      "soSvHienCo": new FormControl('',Validators.required),
      "tang": new FormControl('',Validators.required),
      "maLoaiPhong": new FormControl('',Validators.required),
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
