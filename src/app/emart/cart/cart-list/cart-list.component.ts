import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { Cart } from '../../cart';
import { Item } from '../../item';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})
export class CartListComponent implements OnInit {

  cartItems: Item[];
  showCart: boolean;
  currentBuyer: any;
  constructor(protected emartService: EmartService) { }

  ngOnInit(): void {
    this.currentBuyer = this.emartService.getCurrentBuyer();
    this.cartItems = this.emartService.getAllCart();
    if (this.cartItems.length == 0) {
      this.showCart = false;
    }
    else {
      this.showCart = true;
    }
  }

  //---- Deleting an Item from Cart----//
  deleteCartItem(itemNo: number) {
    this.emartService.deleteCartItem(itemNo);
    this.cartItems = this.emartService.getAllCart();
  }

}
