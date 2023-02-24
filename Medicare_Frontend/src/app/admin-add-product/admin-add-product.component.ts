import { Component, OnInit } from '@angular/core';
import { product } from '../datatype';

import { ProductService } from '../services/product.service';
@Component({
  selector: 'app-admin-add-product',
  templateUrl: './admin-add-product.component.html',
  styleUrls: ['./admin-add-product.component.css']
})
export class AdminAddProductComponent implements OnInit{
  ngOnInit(): void {}
constructor(private prod:ProductService){}

submit(data:product)
{
console.warn(data)
this.prod.saveProduct(data).subscribe((result)=>
console.warn(result)

)

}
}