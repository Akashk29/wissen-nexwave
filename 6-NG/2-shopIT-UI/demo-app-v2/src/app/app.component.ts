import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'shop-IT';
  cart: any = {};
  isCartOpen: boolean = false;
  itemsCount: number = 0;
  products: Array<any> = [
    {
      id: 111,
      name: 'Laptop',
      price: 245000,
      discount:10000,
      currencyCode:'INR',
      description: 'New Mac pro',
      canBuy: true,
      image: 'images/Laptop.png',
      makeDate:Date.now()
    },
    {
      id: 222,
      name: 'I phone-7',
      price: 47000,
      currencyCode:'INR',
      description: 'New  pro',
      canBuy: true,
      image: 'images/Mobile.png',
      makeDate:Date.now()
    }
  ]

  addToCart(event) {
    /*
      {
        '111':{item,qty}
      }
    */
    let item = event.item;
    let qty = event.qty;
    let id = item.id;
    let line = this.cart[id];
    if (line) {
      line = Object.assign({}, line, { qty })
    } else {
      line = Object.assign({ item, qty })
    }
    this.cart = Object.assign({}, this.cart, { [id]: line })
    this.itemsCount = Object.keys(this.cart).length;

  }

  toggleCart() {
    this.isCartOpen = !this.isCartOpen;
  }


}
