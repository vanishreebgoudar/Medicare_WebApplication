import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { product } from '../datatype';
import { ProductService } from '../services/product.service';
import { CustomerService } from '../services/customer.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  menuType: string = 'default';
  sellerName: string = "";
  userName: string = "";
  searchResult:undefined|product[];
  cartItems = 0;
  constructor(private route: Router, private cust: CustomerService,private product:ProductService) { }

  ngOnInit(): void
 {
    this.route.events.subscribe((val: any) => 
    {
      if (val.url) 
      {
        if (localStorage.getItem('cust') && val.url.includes('admin'))
        {
          
          this.menuType = 'admin';
        }
        else if(localStorage.getItem('user'))
        {
          let userStore = localStorage.getItem('user');
          let userData = userStore && JSON.parse(userStore);
          this.userName= userData.name;
          this.menuType='user';
        }
        else 
        {
          this.menuType = 'default';
        }
      }
    });
    let cartData= localStorage.getItem('localCart');
    if(cartData){
      this.cartItems= JSON.parse(cartData).length
    }
    this.product.cartData.subscribe((items)=>{
      this.cartItems= items.length
    })
  }

  logout() {
    localStorage.removeItem('cust');
    this.route.navigate(['/'])
  }
  userLogout(){
    localStorage.removeItem('user');
    this.route.navigate(['/user-auth'])
    
  }
  searchProduct(query:KeyboardEvent){
    if(query){
      const element = query.target as HTMLInputElement;
      this.product.searchProduct(element.value).subscribe((result)=>{
       
        if(result.length>5){
          result.length=length
        }
        this.searchResult=result;
      })
    }
  }
  hideSearch(){
    this.searchResult=undefined
  }
  submitSearch(val:string){
    console.warn(val)
    this.route.navigate([`search/${val}`]);
  }

  redirectToDetails(id:number){
    this.route.navigate(['/details/'+id])
  }
}
