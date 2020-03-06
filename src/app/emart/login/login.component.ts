import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { error } from 'protractor';
import { LoginService } from '../login.service';
import { EmartService } from '../emart.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  sign: string;
  errorMessage: string;
  currentBuyer: any;
  loginserviceService: any;

  constructor(protected emartService: EmartService,
    protected loginService: LoginService,
    protected router: Router) { }

  ngOnInit(): void {
    this.errorMessage = '';
  }

  //----Validating Buyer and Seller----//
  validate() {
    if (this.sign == 'buyer') {
      this.emartService.validateBuyer(this.username, this.password)
        .subscribe(
          (response) => {
            this.currentBuyer = response;
            this.emartService.setBuyerAndBills(this.currentBuyer);
            if (this.currentBuyer.id != 0) {
              this.loginService.loginBuyer(this.currentBuyer);
              this.router.navigate(['item-list']);
            }
            else {
              this.errorMessage = "Invalid Username/Password";
            }
          }
        );
    }

    if (this.sign == 'seller') {
      let result = this.emartService.validateSeller(this.username, this.password);
      if (result != null) {
        this.loginService.loginSeller(result);
        this.router.navigate(['item-list']);
      }
      else {
        this.errorMessage = "Invalid Username/Password";
      }
    }
  }
}
