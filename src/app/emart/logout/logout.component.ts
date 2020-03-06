import { Component, OnInit } from '@angular/core';
import { EmartService } from '../emart.service';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(protected loginService: LoginService,
    protected router: Router) { }

  ngOnInit(): void {
    this.loginService.logout();
    this.router.navigate(['/'])
  }

}
