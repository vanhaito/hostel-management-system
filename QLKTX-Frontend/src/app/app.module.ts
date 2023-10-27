import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {APP_BASE_HREF, CommonModule} from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './share/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ConfirmDialogComponent } from './dialog/confirm-dialog/confirm-dialog.component';
import { NguoiComponent } from './module/nguoi/nguoi.component';
import { SinhVienComponent } from './module/sinh-vien/sinh-vien.component';
import { KhachComponent } from './module/khach/khach.component';
import { KyTucXaComponent } from './module/ky-tuc-xa/ky-tuc-xa.component';
import { PhongComponent } from './module/phong/phong.component';
import { LoaiPhongComponent } from './module/loai-phong/loai-phong.component';
import { VeXeComponent } from './module/ve-xe/ve-xe.component';
import { HopDongComponent } from './module/hop-dong/hop-dong.component';
import { LuotGuiXeComponent } from './module/luot-gui-xe/luot-gui-xe.component';
import { GiatLaComponent } from './module/giat-la/giat-la.component';
import { AddNguoiComponent } from './dialog/add-nguoi/add-nguoi.component';
import { AddSinhVienComponent } from './dialog/add-sinh-vien/add-sinh-vien.component';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import { AddKhachComponent } from './dialog/add-khach/add-khach.component';
import { AddKyTucXaComponent } from './dialog/add-ky-tuc-xa/add-ky-tuc-xa.component';
import { AddLoaiPhongComponent } from './dialog/add-loai-phong/add-loai-phong.component';
import { AddPhongComponent } from './dialog/add-phong/add-phong.component';
import { NhanVienQuanLyComponent } from './module/nhan-vien-quan-ly/nhan-vien-quan-ly.component';
import { AddNhanVienQlComponent } from './dialog/add-nhan-vien-ql/add-nhan-vien-ql.component';
import { AddHopDongComponent } from './dialog/add-hop-dong/add-hop-dong.component';
import { LuotThamComponent } from './module/luot-tham/luot-tham.component';
import { AddLuotThamComponent } from './dialog/add-luot-tham/add-luot-tham.component';
import { AddVeXeComponent } from './dialog/add-ve-xe/add-ve-xe.component';
import { AddLuotGuiXeComponent } from './dialog/add-luot-gui-xe/add-luot-gui-xe.component';
import { AddGiatLaComponent } from './dialog/add-giat-la/add-giat-la.component';
import { HoaDonDienNuocComponent } from './module/hoa-don-dien-nuoc/hoa-don-dien-nuoc.component';
import { AddHoaDonDienNuocComponent } from './dialog/add-hoa-don-dien-nuoc/add-hoa-don-dien-nuoc.component';
import { ThongKeKhachTheoThangComponent } from './module/thong-ke-khach-theo-thang/thong-ke-khach-theo-thang.component';
import { ThongKeDienNuocPhongTheoThangComponent } from './module/thong-ke-dien-nuoc-phong-theo-thang/thong-ke-dien-nuoc-phong-theo-thang.component';

@NgModule({
  declarations: [
    AppComponent,
    ConfirmDialogComponent,
    NguoiComponent,
    SinhVienComponent,
    KhachComponent,
    KyTucXaComponent,
    PhongComponent,
    LoaiPhongComponent,
    VeXeComponent,
    HopDongComponent,
    LuotGuiXeComponent,
    GiatLaComponent,
    AddNguoiComponent,
    AddSinhVienComponent,
    AddKhachComponent,
    AddKyTucXaComponent,
    AddLoaiPhongComponent,
    AddPhongComponent,
    NhanVienQuanLyComponent,
    AddNhanVienQlComponent,
    AddHopDongComponent,
    LuotThamComponent,
    AddLuotThamComponent,
    AddVeXeComponent,
    AddLuotGuiXeComponent,
    AddGiatLaComponent,
    HoaDonDienNuocComponent,
    AddHoaDonDienNuocComponent,
    ThongKeKhachTheoThangComponent,
    ThongKeDienNuocPhongTheoThangComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMatSelectSearchModule
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue: '/'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
