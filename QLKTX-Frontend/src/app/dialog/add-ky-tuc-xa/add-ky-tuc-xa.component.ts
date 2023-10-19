import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-ky-tuc-xa',
  templateUrl: './add-ky-tuc-xa.component.html',
  styleUrls: ['./add-ky-tuc-xa.component.scss']
})
export class AddKyTucXaComponent implements OnInit {
  formControl!: FormGroup ;

  constructor(
    public dialogRef: MatDialogRef<AddKyTucXaComponent>,
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
      "soLuongPhong": new FormControl('',Validators.required),
      "diaChi": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
