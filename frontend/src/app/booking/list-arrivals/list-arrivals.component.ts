import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/models/booking';
import { BookingService } from 'src/app/services/booking.service';
import { Room } from 'src/app/models/room';

@Component({
  selector: 'app-list-arrivals',
  templateUrl: './list-arrivals.component.html',
  styleUrls: ['./list-arrivals.component.css']
})
export class ListArrivalsComponent implements OnInit {

  bookings : Booking[] = [];

  rooms : Room[];

  constructor(private bookingService: BookingService) { }

  ngOnInit() {
    this.bookingService.getBookingNumbersByHotelId(1).subscribe(bookings => {
      this.bookings = bookings;
    })
  }

}
