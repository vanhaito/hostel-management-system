import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class KhachService {
  private baseUrl = `${environment.baseUrl}/khach`;

  constructor(private httpClient: HttpClient) { }

  getAll(){
    const url = `${this.baseUrl}/get-all`;
    return this.httpClient.get<any>(url);
  }

  getKhachById(id: number){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.get<any>(url);
  }

  createKhach(data: any){
    const url = `${this.baseUrl}`;
    return this.httpClient.post<any>(url,data);
  }

  deleteKhach(id: number){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.delete<any>(url);
  }

  update(data: any,id: any){
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.put<any>(url,data);
  }
}
