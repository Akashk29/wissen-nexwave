import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {


  @Input() idx: number = 0;
  @Input() product: any;
  currentTab: number = 1;
  @Output() buy = new EventEmitter();


  reviews: Array<any> = [
    { stars: 5, author: 'who@email.com', body: 'sample-review-1' },
    { stars: 3, author: 'who@email.com', body: 'sample-review-2' }
  ];


  constructor() { }

  ngOnInit() {
  }

  changeTab(event, tabIdx) {
    this.currentTab = tabIdx;
  }
  isTabSelected(tabIdx) {
    return this.currentTab === tabIdx;
  }

  addNewReview(event) {
    this.reviews.push(event.value)
  }
  handleBuy(event) {
    this.buy.emit({ item: this.product, qty: 1 })
  }

}
