import { HttpClient } from '@angular/common/http';
import { Injectable,EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { customer,login } from '../datatype';
import { BehaviorSubject } from 'rxjs';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService
{
  baseUrl: string = "http://localhost:8081/api/customer/";
  isSellerLoggedIn = new BehaviorSubject<boolean>(false);
  isLoginError= new EventEmitter<boolean>(false)
 
  invalidUserAuth= new EventEmitter<boolean>(false)
  constructor(private http: HttpClient, private router: Router) {}
  userSignUp(user: customer) 
  {
    this.http.post(this.baseUrl, user,
      { observe: 'response' }).subscribe((result) => {
        console.warn(result)
        if (result) {
          localStorage.setItem('user', JSON.stringify(result.body))
          this.router.navigate(['/']);
        }
      })

  }
 /* userLogin(data:login){
    this.http.get<signUp[]>(`http://localhost:3000/users?email=${data.email}&password=${data.password}`,
    {observe:'response'}
    ).subscribe((result)=>{
      if(result && result.body?.length){
        localStorage.setItem('user',JSON.stringify(result.body[0]));
        this.router.navigate(['/']);
        this.invalidUserAuth.emit(false)
      }else{
        this.invalidUserAuth.emit(true)
      }
    })
  }
*/
userLogin(data:customer)
  {
  
    this.http.get('http://localhost:8081/api/customer/getuser/'+(data.mail)+'/'+(data.password),
    {observe:'response'}).subscribe((result:any)=>
    {
      console.warn(result)
      if(result && result.body )
      {
        this.isLoginError.emit(false)
        localStorage.setItem('user',JSON.stringify(result.body))
        this.router.navigate(['/'])
      }
      else{
        console.warn("login failed");
        this.isLoginError.emit(true)
      }
    })
   }

  reloadUser() 
  {
    
      if(localStorage.getItem('user')){
        this.router.navigate(['/']);
      }
    
  }
  updateUser(data:any,id:number){
   return  this.http.put('http://localhost:8081/api/OrderProd/'+id,data)

  }

}
