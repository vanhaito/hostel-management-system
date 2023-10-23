import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-hoa-don-dien-nuoc',
  templateUrl: './add-hoa-don-dien-nuoc.component.html',
  styleUrls: ['./add-hoa-don-dien-nuoc.component.scss']
})
export class AddHoaDonDienNuocComponent implements OnInit {
  formControl!: FormGroup ;

  constructor(
    public dialogRef: MatDialogRef<AddHoaDonDienNuocComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maHoaDon":  new FormControl('',Validators.required),
      // "maSoDinhDanhSFilter":  new FormControl(''),
    "ngayLapHoaDon":  new FormControl('',Validators.required),
    "chiSoDienDau":  new FormControl('',Validators.required),
    "chiSoDienCuoi":  new FormControl('',Validators.required),
    "chiSoNuocDau":  new FormControl('',Validators.required),
    "chiSoNuocCuoi":  new FormControl('',Validators.required),
    "donGiaDien":  new FormControl('',Validators.required),
    "donGiaNuoc":  new FormControl('',Validators.required),
    "ngayBatDau":  new FormControl('',Validators.required),
    "ngayKetThuc":  new FormControl('',Validators.required),
    "tenKtx":  new FormControl('',Validators.required),
    "tenPhong":  new FormControl('',Validators.required),
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
