import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { MomentDateAdapter, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';
import { DateAdapter, MAT_DATE_LOCALE, MAT_DATE_FORMATS } from '@angular/material/core';
import { MatDatepicker } from '@angular/material/datepicker';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import * as moment from 'moment';
import { Moment } from 'moment';
import { ThongKeService } from 'src/service/thong-ke.service';
import { MY_FORMATS } from '../thong-ke-khach-theo-thang/thong-ke-khach-theo-thang.component';

@Component({
  selector: 'app-thong-ke-dien-nuoc-phong-theo-thang',
  templateUrl: './thong-ke-dien-nuoc-phong-theo-thang.component.html',
  styleUrls: ['./thong-ke-dien-nuoc-phong-theo-thang.component.scss'],
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
})
export class ThongKeDienNuocPhongTheoThangComponent implements OnInit {
  resultComfirm: string = '';
  formSearch!: FormGroup;

  dataList: any[] = [];

  displayedColumns: string[] = [
    'no',
    "tenKyTucXa",
    "tenPhong",
    "soSvHienCo",
    "tang",
    "maLoaiPhong",
    "ngayBatDau",
    "ngayKetThuc",
    "ngayLapHD",
    "tienDien",
    "tienNuoc"
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
    this.thongKeService.getThongKeTienDienNuocTheoThang(date.getMonth()+1, date.getFullYear()).subscribe((data) => {
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
