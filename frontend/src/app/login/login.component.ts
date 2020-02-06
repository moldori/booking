import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  errorMessage: string;
  loginData: {username: string, password: string} = {username: '', password: ''};

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.auth.login(this.loginData.username, this.loginData.password).
      subscribe(
        () => {
          this.router.navigate(['./newbooking']);
        },
        error => {
          this.handleError(error);
        },
      );
  }


  private handleError(error: any) {
    return (error.status === 400) ? this.errorMessage = 'Invalid username or password!' : '';
  }
}
