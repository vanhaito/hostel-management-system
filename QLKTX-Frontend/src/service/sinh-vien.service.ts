import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SinhVienService {
  private baseUrl = `${environment.baseUrl}/sinh-vien`;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    const url = `${this.baseUrl}/get-all`;
    return this.httpClient.get<any>(url);
  }

  getAllDaKyHD(){
    const url = `${this.baseUrl}/get-all-da-hd`;
    return this.httpClient.get<any>(url);
  }

  getAllChuaKyHD(){
    const url = `${this.baseUrl}/get-all-chua-hd`;
    return this.httpClient.get<any>(url);
  }

  getSinhVienById(id: number){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.get<any>(url);
  }

  createSinhVien(data: any){
    const url = `${this.baseUrl}`;
    return this.httpClient.post<any>(url,data);
  }

  deleteSinhVien(id: number){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.delete<any>(url);
  }

  update(data: any,id: any){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.put<any>(url,data);
  }
}
