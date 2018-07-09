import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../products.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: any = [];

  constructor(private productsService: ProductsService) { }

  ngOnInit() {
    this.productsService.loadProducts()
      .subscribe(products => this.products = products)
  }

  delete(id) {
    this.productsService.delete(id)
      .subscribe(resp => {
        this.products = this.products.filter(item => item.id !== id)
      })
  }

}
