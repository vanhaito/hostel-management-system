import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-nguoi',
  templateUrl: './add-nguoi.component.html',
  styleUrls: ['./add-nguoi.component.scss']
})
export class AddNguoiComponent implements OnInit {
  formControl!: FormGroup ;

  optionGioiTinh = ["Nam", "Nu"];

  optionLoai = ["Sinh vien", "Khach", "Nhan vien"];

  constructor(
    public dialogRef: MatDialogRef<AddNguoiComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maSoDinhDanh":  new FormControl('',Validators.required),
      "ngaySinh": new FormControl('',Validators.required),
      "hoTen": new FormControl('',Validators.required),
      "gioiTinh": new FormControl('',Validators.required),
      "diaChiThuongChu": new FormControl('',Validators.required),
      "loai": new FormControl('',Validators.required)
  });
}

edit(): void {
  var addData = new Object();
  Object.assign(addData, this.formControl.value);
  this.dialogRef.close(addData);
}

}
