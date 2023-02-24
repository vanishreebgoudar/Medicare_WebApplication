export interface customer
{
    name:string;
    mail:string;
    password:string;
    address:string;
    phNo:number;
    custId:number;
}
export interface login {
    mail: String;
    password: String;
  }
  export interface product{
    productName:string,
    productPrice:number,
    category:string,
    brand:string,
    productImg:string,
    productDesc:string,
    qty:number,
    productId:number
  }
  export interface cart
  {
    
    cartId:undefined|number;
    product:product|any,
    user:customer|any,
    cartQty:undefined|number;
  }
  
  export interface priceSummary
  {
    price:number,
    discount:number,
    tax:number,
    delivery:number,
    total:number
  }
  export interface order {
    orderId:undefined|number,
    totalPrice:number,
    user:customer
  }