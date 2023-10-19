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

  constructor(
    public dialogRef: MatDialogRef<AddHopDongComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maHopDong":  new FormControl('',Validators.required),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "ngayBatDau": new FormControl('',Validators.required),
      "ngayKetThuc": new FormControl('',Validators.required),
      "maSv": new FormControl('',Validators.required),
      "maSoDinhDanhN": new FormControl('',Validators.required),
      "tenPhong": new FormControl('',Validators.required),
      "tenKtx": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
