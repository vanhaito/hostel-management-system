import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PhongService {
  private baseUrl = `${environment.baseUrl}/phong`;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    const url = `${this.baseUrl}/get-all`;
    return this.httpClient.get<any>(url);
  }

  getPhongById(tenKyTucXa: any, tenPhong: any){
    const url = `${this.baseUrl}/${tenKyTucXa}/${tenPhong}`;
    return this.httpClient.get<any>(url);
  }

  createPhong(data: any){
    const url = `${this.baseUrl}`;
    return this.httpClient.post<any>(url,data);
  }

  deletePhong(tenKyTucXa: any, tenPhong: any){
    const url = `${this.baseUrl}/${tenKyTucXa}/${tenPhong}`;
    return this.httpClient.delete<any>(url);
  }

  update(data: any, tenKyTucXa: any, tenPhong: any){
    const url = `${this.baseUrl}/${tenKyTucXa}/${tenPhong}`;
    return this.httpClient.put<any>(url,data);
  }
}
