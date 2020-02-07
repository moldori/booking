import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from '../models/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private httpClient: HttpClient) {}

  getBookingNumbersByHotelId(): Observable<Booking[]> {
    return this.httpClient.get<Booking[]>(`http://localhost:8080/api/bookings/current`);
  }

  
}
