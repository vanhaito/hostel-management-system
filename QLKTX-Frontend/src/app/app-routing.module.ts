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
import { VeXeComponent } from './module/ve-xe/ve-xe.component';
import { LuotGuiXeComponent } from './module/luot-gui-xe/luot-gui-xe.component';
import { GiatLaComponent } from './module/giat-la/giat-la.component';
import { HoaDonDienNuocComponent } from './module/hoa-don-dien-nuoc/hoa-don-dien-nuoc.component';
import { ThongKeKhachTheoThangComponent } from './module/thong-ke-khach-theo-thang/thong-ke-khach-theo-thang.component';
import { ThongKeDienNuocPhongTheoThangComponent } from './module/thong-ke-dien-nuoc-phong-theo-thang/thong-ke-dien-nuoc-phong-theo-thang.component';

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
  {path: 've-xe',component: VeXeComponent},
  {path: 'lan-gui-xe',component: LuotGuiXeComponent},
  {path: 'luot-giat',component: GiatLaComponent},
  {path: 'hoa-don-dien-nuoc',component: HoaDonDienNuocComponent},
  {path: 'thong-ke-khach',component: ThongKeKhachTheoThangComponent},
  {path: 'thong-ke-dien-nuoc-thang',component: ThongKeDienNuocPhongTheoThangComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
