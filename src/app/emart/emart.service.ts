import { Injectable } from '@angular/core';
import { Category } from './category';
import { SubCategory } from './sub-category';
import { Item } from './item';
import { Bill } from './bill';
import { Buyer } from './buyer';
import { Seller } from './seller';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EmartService {

  categories: Category[];
  subCategories: SubCategory[];
  allItems: Item[];
  cartItems: Item[];
  allBills: any;
  allSellers: Seller[];
  currentBuyer: any;

  constructor(protected http: HttpClient) {
    this.cartItems = [];
    this.allBills = [];

  }

  //----Retrieving All Items----//
  getAllItems() {
    return this.http.get("http://localhost:8096/emart/item/all");
  }

  //----Adding Category details----//
  getCategories(): Category[] {
    return [].concat(this.categories);
  }

  //----Adding Subcategory Details----//
  getSubCategories(): SubCategory[] {
    return [].concat(this.subCategories);
  }

  //----Retrieving All Bills----//
  getAllBills(): any {
    return this.allBills;
  }

  //----Storing Buyer and Bill details----//
  setBuyerAndBills(currentBuyer) {
    this.currentBuyer = currentBuyer;
    this.allBills = currentBuyer.allBills;
  }

  //----Retrieving Current Buyer----//
  getCurrentBuyer() {
    return this.currentBuyer;
  }

   //----Storing Category array----//
  getCategory(catId: number): Category {
    let category: Category;
    let size = this.categories.length;
    for (let i = 0; i < size; i++) {
      if (this.categories[i].id == catId) {
        category = {
          id: this.categories[i].id,
          name: this.categories[i].name,
          brief: this.categories[i].brief
        };
        break;
      }
    }

    return category;
  }

  //----Storing Subcategory array----//
  getSubCategory(catId: number): SubCategory {
    let subCategory: SubCategory;
    let size = this.subCategories.length;
    for (let i = 0; i < size; i++) {
      if (this.subCategories[i].id == catId) {
        subCategory = {
          id: this.subCategories[i].id,
          name: this.subCategories[i].name,
          brief: this.subCategories[i].brief,
          categoryId: this.subCategories[i].categoryId,
          gstPercent: this.subCategories[i].gstPercent
        };
        break;
      }
    }
    return subCategory;
  }

  //----Retrieving Particular Item----//
  getItem(itemId) {
    return this.http.get("http://localhost:8096/emart/item/" + itemId);
  }

  //---- Adding an Item to Cart List----//
  addToCart(item: any) {
    this.cartItems.push(item);
  }

  //----Retrieving Cart List Items----//
  getAllCart() {
    return [].concat(this.cartItems);
  }

  //----Deleting an Item From Cart List----//
  deleteCartItem(itemNo: number) {
    let size = this.cartItems.length;
    for (let i = 0; i < size; i++) {
      if (this.cartItems[i].id == itemNo) {
        this.cartItems.splice(i, 1);
        break;
      }
    }
  }

//----Storing BillDetails----//
  addBill(todayDate: Date, total: number) {
    let allBillDetails: any = [];
    for (let i = 0; i < this.cartItems.length; i++) {
      allBillDetails.push({
        id: 0,
        billId: null,
        itemId: this.cartItems[i]

      });
    }

    let bill: any = {
      id: 0,
      type: 'Debit',
      date: todayDate,
      remarks: 'paid',
      amount: total,
      buyerId: {
        id: this.currentBuyer.id
      },
      allBillDetails: allBillDetails

    }
    this.cartItems = [];
    return this.http.post("http://localhost:8096/emart/bill", bill);
  }

  //----Retrieving Current Buyer Data----//
  getBuyer() {
    return this.http.get("http://localhost:8096/emart/buyer/" + this.currentBuyer.id);
  }

  //----Buyer Validation----//
  validateBuyer(user: string, password: string) {
    let credentials = user + ":" + password;
    let headers = new HttpHeaders();
    headers = headers.set("Authorization", credentials);
    return this.http.get("http://localhost:8096/emart/validate", { headers });

  }

//----Seller Validation----//
  validateSeller(user: string, password: string) {
    let seller: Seller;
    let size = this.allSellers.length;
    for (let i = 0; i < size; i++) {
      if (this.allSellers[i].username == user && this.allSellers[i].password == password) {
        seller = {
          id: this.allSellers[i].id,
          username: this.allSellers[i].username,
          password: this.allSellers[i].password,
          company: this.allSellers[i].company,
          brief: this.allSellers[i].brief,
          gst: this.allSellers[i].gst,
          address: this.allSellers[i].address,
          email: this.allSellers[i].email,
          website: this.allSellers[i].website,
          contact: this.allSellers[i].contact
        }
        break;
      }
    }
    return seller;
  }

}
