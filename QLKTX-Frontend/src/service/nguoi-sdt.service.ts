import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NguoiSdtService {
  private baseUrl = `${environment.baseUrl}/nguoi-sdt`;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    const url = `${this.baseUrl}/get-all`;
    return this.httpClient.get<any>(url);
  }

  getById(maSoDinhDanh: any, soDienThoai: any){
    const url = `${this.baseUrl}/${maSoDinhDanh}/${soDienThoai}`;
    return this.httpClient.get<any>(url);
  }

  create(data: any){
    const url = `${this.baseUrl}`;
    return this.httpClient.post<any>(url,data);
  }

  delete(maSoDinhDanh: any, soDienThoai: any){
    const url = `${this.baseUrl}/${maSoDinhDanh}/${soDienThoai}`;
    return this.httpClient.delete<any>(url);
  }

  update(data: any, maSoDinhDanh: any, soDienThoai: any){
    const url = `${this.baseUrl}/${maSoDinhDanh}/${soDienThoai}`;
    return this.httpClient.put<any>(url,data);
  }
}
