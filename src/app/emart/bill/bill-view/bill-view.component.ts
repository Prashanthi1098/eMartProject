import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { Item } from '../../item';
import { BillDetails } from '../../bill-details';
import { Bill } from '../../bill';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bill-view',
  templateUrl: './bill-view.component.html',
  styleUrls: ['./bill-view.component.css']
})
export class BillViewComponent implements OnInit {
  cartItems: any;
  todayDate: Date = new Date();
  amount: number = 0;
  allBills: Bill[];
  allBillDetails: BillDetails[];
  currentBuyer: any;

  constructor(protected emartService: EmartService,
    protected router: Router) { }

  ngOnInit(): void {
    this.currentBuyer = this.emartService.currentBuyer;
    this.cartItems = this.emartService.getAllCart();
    let size = this.cartItems.length;
    for (let i = 0; i < size; i++) {
      this.amount = this.amount + this.cartItems[i].price
    }
  }

  addBill() {
    this.emartService
      .addBill(this.todayDate, this.amount)
      .subscribe(
        (res) => {
          this.emartService
            .getBuyer()
            .subscribe(
              (response) => {
                console.log("res:" + response);
                this.currentBuyer = response;
                this.emartService.setBuyerAndBills(this.currentBuyer)


              }
            )
        }
      )
    this.router.navigate(['item-list']);
  }

}
