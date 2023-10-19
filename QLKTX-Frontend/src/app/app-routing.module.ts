import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { KhachComponent } from './module/khach/khach.component';
import { KyTucXaComponent } from './module/ky-tuc-xa/ky-tuc-xa.component';
import { LoaiPhongComponent } from './module/loai-phong/loai-phong.component';
import { NguoiComponent } from './module/nguoi/nguoi.component';
import { SinhVienComponent } from './module/sinh-vien/sinh-vien.component';
import { NhanVienQuanLyComponent } from './module/nhan-vien-quan-ly/nhan-vien-quan-ly.component';
import { HopDongComponent } from './module/hop-dong/hop-dong.component';
import { LuotThamComponent } from './module/luot-tham/luot-tham.component';
import { PhongComponent } from './module/phong/phong.component';

const routes: Routes = [
  {path: '',component: AppComponent},
  {path: 'home',component: AppComponent},
  {path: 'nguoi',component: NguoiComponent},
  {path: 'sinh-vien',component: SinhVienComponent},
  {path: 'loai-phong',component: LoaiPhongComponent},
  {path: 'ky-tuc-xa',component: KyTucXaComponent},
  {path: 'khach',component: KhachComponent},
  {path: 'nhan-vien-quan-ly',component: NhanVienQuanLyComponent},
  {path: 'phong',component: PhongComponent},
  {path: 'hop-dong',component: HopDongComponent},
  {path: 'luot-tham',component: LuotThamComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
