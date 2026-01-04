import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/accounts';

  constructor(private http: HttpClient) {}

  createAccount(account: any): Observable<any> {
    return this.http.post(this.baseUrl, account);
  }

  deposit(id: number, amt: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/${id}/deposit/${amt}`, {});
  }

  withdraw(id: number, amt: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/${id}/withdraw/${amt}`, {});
  }

  transfer(from: number, to: number, amt: number): Observable<any> {
    let params = new HttpParams()
      .set('from', from)
      .set('to', to)
      .set('amt', amt);

    return this.http.post(`${this.baseUrl}/transfer`, null, { params });
  }

  transactions(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}/transactions`);
  }
}
