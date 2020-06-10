import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PecuniaService {

  selectedAccountToUpdate: Account;

  api = `http://localhost:8080`;
  constructor(private http: HttpClient) { }

  addAccount(account): Observable<any> {
    return this.http.post<any>(`${this.api}/add-account`, account);
  }

  getAccount(): Observable<any> {
    return this.http.get<any>(`${this.api}/get-account`);
  }

  deleteAccount(account: Account): Observable<any> {
    return this.http.delete<any>(`${this.api}/delete-account/${account.accountNo}`);
  }

  updateAccount(account): Observable<any> {
    return this.http.put<any>(`${this.api}/update-account`, account);
  }

  searchAccount(account): Observable<any> {
    return this.http.get<any>(`${this.api}/search-account/${account.accountNo}`);
  }

  // ----------------------------------------------------------------------------------------

  register(user): Observable<any> {
    return this.http.post<any>(`${this.api}/register-user`, user);
  }

  login(user): Observable<any> {
    return this.http.post<any>(`${this.api}/login-user`, user);
  }

  updatePassword(user): Observable<any> {
    return this.http.put<any>(`${this.api}/update-password`, user);
  }

}
