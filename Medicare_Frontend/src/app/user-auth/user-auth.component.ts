import { Component } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';
import { cart,product,customer,login } from '../datatype';
import { UserService } from '../services/user.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-user-auth',
  templateUrl: './user-auth.component.html',
  styleUrls: ['./user-auth.component.css']
})
export class UserAuthComponent 
{
  user:undefined | customer;
  showLogin = false;
  authError: String = '';

  constructor(private user1:UserService,private cust:CustomerService,private router: Router,private product:ProductService) {}

  ngOnInit(): void 
  {
    this.user1.reloadUser();
  }

  signUp(data: customer): void 
  {
    console.warn(data);
    this.user1.userSignUp(data);
  }
  login(data: customer): void 
  {
    this.user1.userLogin(data);
    this.user1.isLoginError.subscribe((isError) =>
     {
      if (isError) {this.authError = "Email or password is not correct";}
    })

  }

 /* login(data: customer) {
    this.user.userLogin(data)
    this.user.invalidUserAuth.subscribe((result)=>{
      console.warn(result);
      if(result){
         this.authError="User not found"
      }
      
    })
  }*/
  openLogin() {
    this.showLogin = true
  }
  openSignUp() {
    this.showLogin = false
  }
  
 /* localCartToRemoteCart(){
    let data = localStorage.getItem('localCart');
    let user = localStorage.getItem('user');
    let userId= user && JSON.parse(user).id;
    if(data)
    {
     let cartDataList:product[]= JSON.parse(data);
     this.cust.getcustomer(userId).subscribe((data)=>
    {
         
          this.user=data
         
        
     cartDataList.forEach((product:product, index)=>
     {
       let cartData:cart={
        user:this.user,
        cartId:1,
        cartQty:qty
         
       }
       delete cartData.id;
       setTimeout(() => {
         this.product.addToCart(cartData).subscribe((result)=>{
           if(result){
             console.warn("data is stored in DB");
           }
         })
       }, 500);
       if(cartDataList.length===index+1){
         localStorage.removeItem('localCart')
       }
     })
    }
*/


}
