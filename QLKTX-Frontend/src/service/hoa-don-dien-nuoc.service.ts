import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HoaDonDienNuocService {
  private baseUrl = `${environment.baseUrl}/hoa-don-dien-nuoc`;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    const url = `${this.baseUrl}/get-all`;
    return this.httpClient.get<any>(url);
  }

  getHoaDonDienNuocById(id: number){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.get<any>(url);
  }

  createHoaDonDienNuoc(data: any){
    const url = `${this.baseUrl}`;
    return this.httpClient.post<any>(url,data);
  }

  deleteHoaDonDienNuoc(id: number){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.delete<any>(url);
  }

  update(data: any,id: any){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.put<any>(url,data);
  }
}
