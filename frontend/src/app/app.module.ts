import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { BarComponent } from './bar/bar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { GuestComponent } from './guest/guest.component';
import { HotelComponent } from './hotel/hotel.component';
import { BookingComponent } from './booking/booking.component';
import { RoomComponent } from './room/room.component';
import { GueatListComponent } from './guest/gueat-list/gueat-list.component';
import { RouterModule, Routes } from '@angular/router';
import { NewbookingComponent } from './booking/newbooking/newbooking.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MatRadioModule } from '@angular/material/radio';
import { AuthGuard } from './services/auth-guard';
import { ListArrivalsComponent } from './booking/list-arrivals/list-arrivals.component';
import { ListLeavingComponent } from './booking/list-leaving/list-leaving.component';
import { AuthInterceptorService } from './services/auth-interceptor.service';


const router: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: "login", component: LoginComponent },
  { path: "newbooking", component: NewbookingComponent, canActivate: [AuthGuard] },
  { path: "list-arivals", component: ListArrivalsComponent, canActivate: [AuthGuard] },
  { path: "list-leaving", component: ListLeavingComponent, canActivate: [AuthGuard] },
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BarComponent,
    GuestComponent,
    HotelComponent,
    BookingComponent,
    RoomComponent,
    GueatListComponent,
    NewbookingComponent,
    ListArrivalsComponent,
    ListLeavingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    RouterModule.forRoot(router),
    FormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatRadioModule
  ],
  providers: [
    MatDatepickerModule,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
