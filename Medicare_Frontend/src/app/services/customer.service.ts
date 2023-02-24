import { HttpClient } from '@angular/common/http';
import { Injectable,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { customer,login } from '../datatype';
import { BehaviorSubject } from 'rxjs';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  baseUrl: string = "http://localhost:8081/api/customer/";
  isSellerLoggedIn = new BehaviorSubject<boolean>(false);
  isLoginError= new EventEmitter<boolean>(false)
 

  constructor(private http: HttpClient, private router: Router) {
    

  }

  adminSignUp(cust: customer) 
  {
    this.http.post(this.baseUrl, cust,
      { observe: 'response' }).subscribe((result) => {
        console.warn(result)
        if (result) {
          localStorage.setItem('cust', JSON.stringify(result.body))
          this.router.navigate(['admin-home'])
        }
      })

  }
  adminLogin(data:customer)
  {
  
    this.http.get('http://localhost:8081/api/customer/getuser/'+(data.mail)+'/'+(data.password),
    {observe:'response'}).subscribe((result:any)=>
    {
      console.warn(result)
      if(result && result.body )
      {
        this.isLoginError.emit(false)
        localStorage.setItem('cust',JSON.stringify(result.body))
        this.router.navigate(['admin-home'])
      }
      else{
        console.warn("login failed");
        this.isLoginError.emit(true)
      }
    })
   }

  reloadSeller() 
  {
    if (localStorage.getItem('cust')) 
    {
      this.isSellerLoggedIn.next(true)
      this.router.navigate(['admin-home'])
    }
  }
  getcustomer(id:number){

    return this.http.get<customer>(this.baseUrl+id);
  }
}
