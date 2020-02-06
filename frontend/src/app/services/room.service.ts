import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private httpClient : HttpClient) { }

  getRoomNumbersByHotelId(hotelid : number): Observable<Room[]> {
    return this.httpClient.get<Room[]>(`http://localhost:8080/api/rooms/findAllByHotelId/${hotelid}`);
  }

}
