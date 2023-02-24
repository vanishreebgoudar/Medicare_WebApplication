import { HttpBackend, HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { product,cart ,order} from '../datatype';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  baseUrl:string="http://localhost:8081/api/product/";
  cartData = new EventEmitter<product[] | []>();
  constructor(private http:HttpClient) { }



  getAllProducts(){
    return this.http.get<product[]>(this.baseUrl);
   }
   getProductById(id:number){
     return this.http.get<product>(this.baseUrl+id);
   }
  
  deleteProdById(id:number){
    return this.http.delete(this.baseUrl+id);
  }
   saveProduct(data:product){
     return this.http.post(this.baseUrl,data);
   }
   updateProduct(prod:product){
     return this.http.put(this.baseUrl+prod.productId,prod);
   }
   popularProducts(){
    return this.http.get<product[]>('http://localhost:8081/api/product?_limit=3');
   }
    trendyProducts() {
      return this.http.get<product[]>('http://localhost:8081/api/product?_limit=8');
    }
    searchProduct(query: string) {
      return this.http.get<product[]>('http://localhost:8081/api/product/getUser/'+(query));
    }

    localAddToCart(data: product) {
      let cartData = [];
      let localCart = localStorage.getItem('localCart');
      if (!localCart) {
        localStorage.setItem('localCart',(JSON.stringify([data])));
        this.cartData.emit([data]);
      } else {
        cartData = JSON.parse(localCart);
        cartData.push(data);
        localStorage.setItem('localCart', JSON.stringify(cartData));
        this.cartData.emit(cartData);
      }
    }
  
    removeItemFromCart(productId: number)
     {
      let cartData = localStorage.getItem('localCart');
      if (cartData)
       {
        let items: product[] = JSON.parse(cartData);
        console.warn(items)
        items = items.filter((item: product) => productId !== item.productId);
        console.warn(items)
        localStorage.setItem('localCart', JSON.stringify(items));
        this.cartData.emit(items);
      }
    }
  
    addToCart(cartData: cart) 
    {
      return this.http.post('http://localhost:8081/api/cart', cartData);
    }
    getCartList(userId: number)
     {
      return this.http.get<product[]>('http://localhost:8081/api/cart/getProd/'+userId,{
          observe: 'response',
        })
        .subscribe((result) => {
          if (result && result.body) {
            this.cartData.emit(result.body);
          }
        });
    }
    removeToCart(cartId: number) 
    {
      console.warn("inside remove cart product service")
      return this.http.delete('http://localhost:8081/api/cart/'+cartId);
    }
    currentCart()
     {
      let userStore = localStorage.getItem('user');
      let userData = userStore && JSON.parse(userStore);
      return this.http.get<cart[]>('http://localhost:8081/api/cart/getCart/'+ userData.id);
    }
    orderNow(data: order) {
      return this.http.post('http://localhost:8081/api/OrderProd/', data);
    }
    orderList() {
      let userStore = localStorage.getItem('user');
      let userData = userStore && JSON.parse(userStore);
      return this.http.get<order[]>('http://localhost:3000/orders?userId=' + userData.id);
    }
  
    deleteCartItems(cartId: number) {
      return this.http.delete('http://localhost:3000/cart/' + cartId).subscribe((result) => {
        this.cartData.emit([]);
      })
    }
  
    cancelOrder(orderId:number){
      return this.http.delete('http://localhost:3000/orders/'+orderId)
  
    }



   }



