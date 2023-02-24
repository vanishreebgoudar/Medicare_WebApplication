import { Component, OnInit } from '@angular/core';
import { product } from '../datatype';
import { ProductService } from '../services/product.service';
import { faTrash, faEdit } from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  constructor(private prod:ProductService) {}
  productList: undefined | product[];
  productMessage:undefined| any;
  icon = faTrash;
  iconEdit=faEdit;

  ngOnInit(): void {
    
   this.list();
}
deleteProduct(id: number) {
  this.prod.deleteProdById(id).subscribe((data)=>{
   if(data='true') {
    this.productMessage='Product is deleted';
    this.list();
   }
  });
  setTimeout(() => {
    this.productMessage = undefined;
  }, 3000);
  }
  
list() {
  this.prod.getAllProducts().subscribe((result) => {
    if (result) {
      console.warn(result)
      this.productList = result;
    }
  });
}



}