import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  constructor(private httpClient: HttpClient) { }

  getGuestById(id: number) {
    return this.httpClient.get('http://localhost:8080/api/guests/' + id)
  }

}
