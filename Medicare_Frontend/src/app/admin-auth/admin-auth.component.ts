import { Component } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';
import { customer, login } from '../datatype';
@Component({
  selector: 'app-admin-auth',
  templateUrl: './admin-auth.component.html',
  styleUrls: ['./admin-auth.component.css']
})
export class AdminAuthComponent {
  showLogin = false;
  authError: String = '';

  constructor(private cust: CustomerService, private router: Router) {

  }

  ngOnInit(): void {
    this.cust.reloadSeller()
  }

  signUp(data: customer): void {
    console.warn(data);
    this.cust.adminSignUp(data);
  }
  login(data: customer): void {
    this.cust.adminLogin(data);
    this.cust.isLoginError.subscribe((isError) => {
      if (isError) {
        this.authError = "Email or password is not correct";
      }
    })

  }
  openLogin() {
    this.showLogin = true
  }
  openSignUp() {
    this.showLogin = false
  }
}
