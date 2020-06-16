import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})


// DataService is to call backend service for requesting data
export class DataService {

  constructor(private http: HttpClient) {
  }

  getUser(email): Observable<any> {
    return this.http.get(environment.API_PROFILE +  email , httpOptions);
  }

  updateUser(user): Observable<any> {
    return this.http.put(environment.API_PROFILE + 'user', user, httpOptions);
  }
}
