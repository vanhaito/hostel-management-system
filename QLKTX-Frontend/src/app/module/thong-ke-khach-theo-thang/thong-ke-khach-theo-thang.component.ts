import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MomentDateAdapter, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';
import { DateAdapter, MAT_DATE_LOCALE, MAT_DATE_FORMATS } from '@angular/material/core';
import { MatDatepicker, MatDatepickerModule } from '@angular/material/datepicker';
import { MatDialog } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import * as moment from 'moment';
import { Moment } from 'moment';
import { AddSinhVienComponent } from 'src/app/dialog/add-sinh-vien/add-sinh-vien.component';
import { ConfirmDialogModel, ConfirmDialogComponent } from 'src/app/dialog/confirm-dialog/confirm-dialog.component';
import { NguoiService } from 'src/service/nguoi.service';
import { SinhVienService } from 'src/service/sinh-vien.service';
import { ThongKeService } from 'src/service/thong-ke.service';

export const MY_FORMATS = {
  parse: {
    dateInput: 'MM/YYYY',
  },
  display: {
    dateInput: 'MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-thong-ke-khach-theo-thang',
  templateUrl: './thong-ke-khach-theo-thang.component.html',
  styleUrls: ['./thong-ke-khach-theo-thang.component.scss'],
  providers: [
    // `MomentDateAdapter` can be automatically provided by importing `MomentDateModule` in your
    // application's root module. We provide it at the component level here, due to limitations of
    // our example generation script.
    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS],
    },
    {provide: MAT_DATE_FORMATS, useValue: MY_FORMATS},
  ],
  encapsulation: ViewEncapsulation.None,
  // standalone: true,
  // imports: [
  //   MatFormFieldModule,
  //   MatInputModule,
  //   MatDatepickerModule,
  //   FormsModule,
  //   ReactiveFormsModule,
  // ],
})
export class ThongKeKhachTheoThangComponent implements OnInit {
  resultComfirm: string = '';
  formSearch!: FormGroup;

  dataList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "maSv",
    "lop",
    "maSoDinhDanhS",
    "maSoDinhDanhK",
    "ngheNghiep",
    "hoTen",
    "gioiTinh",
    "ngaySinh",
    "diaChiThuongChu",
    "soLuotTham",
  ];
  dataSource = new MatTableDataSource<any>();

  // @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  constructor(
    private thongKeService: ThongKeService,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.makeSearchForm();
    this.onSearch();
  }

  onSearch(){
    var date = new Date(this.formSearch.controls['dateTime'].value!);
    this.thongKeService.getThongKeKhachTheoThang(date.getMonth()+1, date.getFullYear()).subscribe((data) => {
      console.log(data);
      this.dataList = data;
      console.log(this.dataList);
      this.dataSource = new MatTableDataSource<any>(this.dataList);
    });
  }

  makeSearchForm() {
    this.formSearch = new FormGroup({
      dateTime: new FormControl(moment()),
    });
  }

  setMonthAndYear(normalizedMonthAndYear: Moment, datepicker: MatDatepicker<Moment>) {
    const ctrlValue = this.formSearch.controls['dateTime'].value!;
    ctrlValue.month(normalizedMonthAndYear.month());
    ctrlValue.year(normalizedMonthAndYear.year());
    this.formSearch.controls['dateTime'].setValue(ctrlValue);
    datepicker.close();
  }


  openSnackBar(content: any) {
    this._snackBar.open(content, 'OK', {
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }
}
