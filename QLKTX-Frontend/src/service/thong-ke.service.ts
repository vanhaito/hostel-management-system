import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ThongKeService {
  private baseUrl = `${environment.baseUrl}/thong-ke`;

  constructor(private httpClient: HttpClient) { }

  getThongKeKhachTheoThang(month: any, year: any){
    const url = `${this.baseUrl}/khach-theo-thang/${month}/${year}`;
    return this.httpClient.get<any>(url);
  }

  getThongKeTienDienNuocTheoThang(month: any, year: any){
    const url = `${this.baseUrl}/dien-nuoc-theo-thang/${month}/${year}`;
    return this.httpClient.get<any>(url);
  }

  getThongKeTongTienSVTheoThang(month: any, year: any){
    const url = `${this.baseUrl}/tong-tien-sv-theo-thang/${month}/${year}`;
    return this.httpClient.get<any>(url);
  }

  getThongKeTienDichVuSVTheoThang(month: any, year: any){
    const url = `${this.baseUrl}/tien-dich-vu-sv-theo-thang/${month}/${year}`;
    return this.httpClient.get<any>(url);
  }
}
