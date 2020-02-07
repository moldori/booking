import { Hotel } from "./hotel";
import { Guest } from "./guest";
import { Room } from './room';

export class Booking {

    id : number;

    hotel  : Hotel;

    guest : Guest;

    checkIn : Date;

    checkOut : Date;

    rooms: Room[];


}
