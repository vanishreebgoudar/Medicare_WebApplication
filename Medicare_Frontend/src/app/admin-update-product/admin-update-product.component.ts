import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { product } from '../datatype';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-admin-update-product',
  templateUrl: './admin-update-product.component.html',
  styleUrls: ['./admin-update-product.component.css']
})
export class AdminUpdateProductComponent implements OnInit
{
  productId:undefined| any;
  Id:number;
  productData:undefined| product;
  productMessage: undefined | string;
  constructor(private route: ActivatedRoute, private product:ProductService)
   {

    this.productId= this.route.snapshot.paramMap.get('id');
    console.warn(this.productId);
    
      this.product.getProductById(this.productId).subscribe((data) => {
       
        this.productData=data;
      });
  }
  ngOnInit(): void
   {


  }

  submit(data:product){
    if (this.productData) {
      data.productId= this.productData.productId;
    }

    this.product.updateProduct(data).subscribe((result) => {
      if (result) {
        this.productMessage = 'Product has updated';
      }
      else {
        this.productMessage = 'Product has not updated';
      }
    });
    setTimeout(() => {
      this.productMessage = undefined;
    }, 3000);
    
    console.warn(data);
  
 
 
 
}

}

