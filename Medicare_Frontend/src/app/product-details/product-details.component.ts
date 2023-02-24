import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {  product,cart,customer } from '../datatype';
import { CustomerService } from '../services/customer.service';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit
{  
  user:undefined | customer;
  productData:undefined | product;
  productId:undefined|any;
  productQuantity:number=1;
  removeCart=false;
  cartData:undefined|product;
  cartVar:undefined|cart;
  constructor(private router: Router,private activeRoute:ActivatedRoute, private product:ProductService,private cust:CustomerService) { }

  ngOnInit(): void 
  {
    let productId= this.activeRoute.snapshot.paramMap.get('productId');
    console.warn(productId);

    this.productId= this.activeRoute.snapshot.paramMap.get('id');
    this.product.getProductById(this.productId).subscribe((data)=> 
    {
      this.productData= data;
     /* let cartData= localStorage.getItem('localCart');
      
      if(this.productId && cartData)
      {
        console.warn("inside data")
        let items=JSON.parse(cartData);
        items = items.filter((item:product)=>this.productId=== item.productId.toString());
        if(items.length)
        {
          this.removeCart=true
        }else
        {
          this.removeCart=false
        }
      }*/

      let user = localStorage.getItem('user');
      if(user)
      {
        let userId= user && JSON.parse(user).id;
        this.product.getCartList(userId);

        this.product.cartData.subscribe((result)=>
      {
        let item = result.filter((item:product)=>this.productId?.toString()===item.productId?.toString())
       if(item.length)
       {
        this.cartData=item[0];
        this.removeCart=true;
       }
        })
      }
      
      
      
    })
    
  }
  handleQuantity(val:string){
    if(this.productQuantity<20 && val==='plus'){
      this.productQuantity+=1;
    }else if(this.productQuantity>1 && val==='min'){
      this.productQuantity-=1;
    }
  }

  addToCart()
  {
   
    if(this.productData)
    {
      let qty = this.productQuantity;
      
      if(!localStorage.getItem('user'))
      {
        this.router.navigate(['user-auth'])
        /*this.product.localAddToCart(this.productData);
        this.removeCart=true
        */
      }
      else{
        
        let user1 = localStorage.getItem('user');
        let userId= user1 && JSON.parse(user1).id;
        this.cust.getcustomer(userId).subscribe((data)=>
        {
         
          this.user=data
         
        
        console.warn(this.user);
        this.cartVar={
          product:this.productData,
          user:this.user,
          cartId:1,
          cartQty:qty
        }
        delete this.cartVar.cartId;
       
        this.product.addToCart(this.cartVar).subscribe((result)=>{
          if(result){
            console.warn(result)
           this.product.getCartList(userId);
           this.removeCart=true
          }
        })        
      })
    }
    } 
  }
  removeToCart(productId:number)
  {
    if(!localStorage.getItem('user'))
    {
    
    this.product.removeItemFromCart(productId)
    }
    else{
      console.warn("cartData", this.cartData);
      
      this.cartData && this.product.removeToCart(this.cartData.productId)
      .subscribe((result)=>{
        let user = localStorage.getItem('user');
        let userId= user && JSON.parse(user).id;
        this.product.getCartList(userId)
      })
    }
    this.removeCart=false
  }

  
}