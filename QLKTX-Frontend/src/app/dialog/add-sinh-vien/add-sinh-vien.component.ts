import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-sinh-vien',
  templateUrl: './add-sinh-vien.component.html',
  styleUrls: ['./add-sinh-vien.component.scss']
})
export class AddSinhVienComponent implements OnInit {
  formControl!: FormGroup ;

  constructor(
    public dialogRef: MatDialogRef<AddSinhVienComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maSoDinhDanhS":  new FormControl('',Validators.required),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "maSv": new FormControl('',Validators.required),
      "lop": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
