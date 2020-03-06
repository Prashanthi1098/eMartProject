import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from '../../item';
import { Category } from '../../category';
import { SubCategory } from '../../sub-category';
import { EmartService } from '../../emart.service';

@Component({
  selector: 'app-item-display',
  templateUrl: './item-display.component.html',
  styleUrls: ['./item-display.component.css']
})
export class ItemDisplayComponent implements OnInit {

  item: any;
  category: Category;
  subCategory: SubCategory;

  constructor(protected activatedRoute: ActivatedRoute,
    protected emartService: EmartService,
    protected router: Router) { }

  ngOnInit(): void {
    this.activatedRoute
      .paramMap
      .subscribe(
        (param) => {
          let id = param.get('iId');
          this.emartService.getItem(id).subscribe(
            (response: any) => {
              this.item = response;
            }
          );
        }
      );
  }

  //---- Adding an Item to Cart and Navigating to Item List----//
  addToCart(itemId: any) {
    this.emartService.addToCart(itemId);
    this.router.navigate(['item-list']);
  }

}
