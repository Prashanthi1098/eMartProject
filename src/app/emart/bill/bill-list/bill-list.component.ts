import { Component, OnInit } from '@angular/core';
import { EmartService } from '../../emart.service';
import { Item } from '../../item';
import { Bill } from '../../bill';

@Component({
  selector: 'app-bill-list',
  templateUrl: './bill-list.component.html',
  styleUrls: ['./bill-list.component.css']
})
export class BillListComponent implements OnInit {

  allBills: Bill[];
  showBill: boolean;
  currentBuyer: any;
  constructor(protected emartService: EmartService) { }

  ngOnInit(): void {
    this.currentBuyer = this.emartService.getCurrentBuyer();
    this.allBills = this.emartService.getAllBills();
    if (this.allBills.length == 0) {
      this.showBill = false;
    }
    else {
      this.showBill = true;
    }

  }

}
