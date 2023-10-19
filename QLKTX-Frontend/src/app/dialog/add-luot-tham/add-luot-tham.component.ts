import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-add-luot-tham',
  templateUrl: './add-luot-tham.component.html',
  styleUrls: ['./add-luot-tham.component.scss']
})
export class AddLuotThamComponent implements OnInit {
  formControl!: FormGroup ;
  dateEnd : any;
  dateStart: any;

  constructor(
    public dialogRef: MatDialogRef<AddLuotThamComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {}

  ngOnInit(): void {

    this.makeForm();
    this.dateEnd = new Date(this.data.luotTham.thoiGianDi) ?? new Date();
    this.dateStart = new Date(this.data.luotTham.thoiGianDen) ?? new Date();
    // this.formControl.setValue(this.data);
  }

makeForm(){
    this.formControl = new FormGroup({
      "maLuotTham":  new FormControl(''),
      // "maSoDinhDanhSFilter":  new FormControl(''),
      "thoiGianDen": new FormControl('',Validators.required),
      "thoiGianDi": new FormControl('',Validators.required),
      "maSv": new FormControl('',Validators.required),
      "maSoDinhDanhK": new FormControl('',Validators.required),
  });
}

edit(): void {
  var addData: any = {};
  Object.assign(addData, this.formControl.value);

  // addData.thoiGianDi = addData.thoiGianDi + '';
  //   const words = addData.thoiGianDi.split(' (');
  //   var time = '';
  //   var date = new Date(words[0]);
  //   var d = words[0].split(' ');

  //   time = `${date.getFullYear()}-${
  //     date.getMonth() + 1 < 10 ? `0${date.getMonth() + 1}` : date.getMonth() + 1
  //   }-${date.getDate()+1 < 10 ? `0${date.getDate() + 1}` : date.getDate() + 1}T${
  //     d[4]
  //   }`;
  //   console.log(time);
  //   addData.thoiGianDi = time;


  //   addData.thoiGianDen = addData.thoiGianDen + '';
  //   const words2 = addData.thoiGianDen.split(' (');
  //   var time2 = '';
  //   var date2 = new Date(words2[0]);
  //   var d2 = words2[0].split(' ');
  //   time2 = `${date2.getFullYear()}-${
  //     date2.getMonth() + 1 < 10 ? `0${date2.getMonth() + 1}` : date2.getMonth() + 1
  //   }-${date2.getDate()+1 < 10 ? `0${date2.getDate() + 1}` : date2.getDate() + 1}T${
  //     d2[4]
  //   }`;
  //   console.log(time2);
  //   addData.thoiGianDen = time2;

  this.dialogRef.close(addData);
}

}
