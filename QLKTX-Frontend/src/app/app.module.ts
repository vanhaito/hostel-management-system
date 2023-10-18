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
    AddNguoiComponent
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
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue: '/'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
