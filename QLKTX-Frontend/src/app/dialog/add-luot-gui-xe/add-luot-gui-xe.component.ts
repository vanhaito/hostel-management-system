import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-luot-gui-xe',
  templateUrl: './add-luot-gui-xe.component.html',
  styleUrls: ['./add-luot-gui-xe.component.scss']
})
export class AddLuotGuiXeComponent implements OnInit {
  formControl!: FormGroup ;
  dateEnd : any;
  dateStart: any;

  constructor(
    public dialogRef: MatDialogRef<AddLuotGuiXeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    this.dateEnd = new Date(this.data.luotGuiXe.thoiGianLay) ?? new Date();
    this.dateStart = new Date(this.data.luotGuiXe.thoiGianGui) ?? new Date();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maLanGui":  new FormControl(''),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "thoiGianGui": new FormControl('',Validators.required),
      "thoiGianLay": new FormControl('',Validators.required),
      "bienSoXe": new FormControl('',Validators.required),
      // "maSv": new FormControl('',Validators.required),
  });
}

edit(): void {
  var addData: any = {};
  Object.assign(addData, this.formControl.value);

  this.dialogRef.close(addData);
}
}
