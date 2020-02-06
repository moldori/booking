import { Component, OnInit } from '@angular/core';
import {FormControl, ReactiveFormsModule} from '@angular/forms';
import {RoomService} from 'src/app/services/room.service'
import { Room } from 'src/app/models/room';

@Component({
  selector: 'app-newbooking',
  templateUrl: './newbooking.component.html',
  styleUrls: ['./newbooking.component.css']
})
export class NewbookingComponent implements OnInit {

  constructor(private roomService: RoomService) { }

  myControl = new FormControl();
  options: Room[];
  


  roomnumbers: any;



  ngOnInit() {
    this.roomService.getRoomNumbersByHotelId(1).subscribe(rooms => {
      this.options = rooms;
    })
  }


}
