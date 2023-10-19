import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-khach',
  templateUrl: './add-khach.component.html',
  styleUrls: ['./add-khach.component.scss']
})
export class AddKhachComponent implements OnInit {
  formControl!: FormGroup ;

  constructor(
    public dialogRef: MatDialogRef<AddKhachComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maSoDinhDanhK":  new FormControl('',Validators.required),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "ngheNghiep": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
