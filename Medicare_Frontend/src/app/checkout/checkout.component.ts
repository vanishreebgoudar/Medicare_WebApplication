import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {customer, cart,order, priceSummary} from '../datatype';
import { CustomerService } from '../services/customer.service';
import { ProductService } from '../services/product.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit
{

  user:undefined | customer;
  totalPrice: number | undefined;
  cartData: cart[] | undefined;
  orderMsg: string | undefined;
  orderData:order|undefined;
  priceSummary: priceSummary = {
    price: 0,
    discount: 0,
    tax: 0,
    delivery: 0,
    total: 0
  }
  constructor(private product: ProductService, private router: Router,private userServ:UserService,private cust:CustomerService) { }

  ngOnInit(): void {
    this.product.currentCart().subscribe((result) => {
      this.cartData = result;
      console.warn(this.cartData);
      let price = 0;
      result.forEach((item) => 
      {
        if (item.cartQty) 
        {
          
          price = price + (+item.product.productPrice * +item.cartQty)
          console.warn(price)
        }
      })
      this.priceSummary.price = price;
      this.priceSummary.discount = price / 10;
      this.priceSummary.tax = price / 10;
      this.priceSummary.delivery = 100;
      this.priceSummary.total = price + (price / 10) + 100 - (price / 10);

    if(!this.cartData.length){
      this.router.navigate(['/'])
    }

    })

    

  }
  orderNow(ABC: any) {
    console.warn("come inside")
    let user1 = localStorage.getItem('user');
    let userId = user1 && JSON.parse(user1).id;
    this.cust.getcustomer(userId).subscribe((data)=>
  {
    this.user=data
    this.user.address=ABC.address;
    this.user.phNo=ABC.phno;
    if(userId)
    {
      console.warn("user id"+userId)
      this.userServ.updateUser(this.user,userId).subscribe((data)=>{})
    console.warn(data)
    
    }
    if (this.totalPrice) {
      this.orderData={
        user:this.user,
        totalPrice:this.totalPrice,
        orderId:1
       
      }
      delete this.orderData.orderId;
      this.cartData?.forEach((item) => {
        setTimeout(() => {
          item.cartId && this.product.deleteCartItems(item.cartId);
        }, 700)
      })

      this.product.orderNow(this.orderData).subscribe((result) => {
        if (result) {
          this.orderMsg = "Order has been placed";
          setTimeout(() => {
            this.orderMsg = undefined;
            this.router.navigate(['/my-orders'])
          }, 4000);

        }

      })
    }
  })
}}
