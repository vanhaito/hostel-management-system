import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-nhan-vien-ql',
  templateUrl: './add-nhan-vien-ql.component.html',
  styleUrls: ['./add-nhan-vien-ql.component.scss']
})
export class AddNhanVienQlComponent implements OnInit {
  formControl!: FormGroup ;

  constructor(
    public dialogRef: MatDialogRef<AddNhanVienQlComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maSoDinhDanhN":  new FormControl('',Validators.required),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "trinhDo": new FormControl('',Validators.required),
      "tenKyTucXa": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
