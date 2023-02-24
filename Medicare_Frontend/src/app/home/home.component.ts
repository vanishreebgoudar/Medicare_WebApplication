import { Component, OnInit } from '@angular/core';
import { product } from '../datatype';
import { ProductService } from '../services/product.service';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  
})
export class HomeComponent implements OnInit
 {
 

  popularProducts:undefined|product[];
  trendyProducts:undefined | product[];
   constructor(private product:ProductService) {}
 
   ngOnInit(): void 
   {
    this.product.popularProducts().subscribe((data)=>{
      this.popularProducts=data;
      
    })
 this.product.trendyProducts().subscribe((data)=>
    {
      this.trendyProducts=data;
    })
    
    
   }
   filterBrand(value:any)
   {

   }
  }

