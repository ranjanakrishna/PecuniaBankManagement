import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search-account',
  templateUrl: './search-account.component.html',
  styleUrls: ['./search-account.component.css']
})
export class SearchAccountComponent implements OnInit {

  message: any;
  accounts: Account[];
  constructor(private pecuniaservice: PecuniaService,
    private router: Router) { }

  ngOnInit() {
  }

  searchAccount(form: NgForm) {
    console.log(form.value);
    this.pecuniaservice.searchAccount(form.value).subscribe(response => {
      console.log(response);
      this.accounts = response.beans;
      this.message = response.description;
      setTimeout(() => {
        this.message = null;
      }, 10000);
    })
  }

  selectAccount(account) {
    console.log(account);
    this.router.navigate([`update-account/${account.accountNo}`], {
      queryParams: {
        customerName: account.customerName,
        address: account.address,
        city: account.city,
        state: account.state,
        country: account.country,
        phoneNo: account.phoneNo,
        aadhaarNo: account.aadhaarNo,
        panNo: account.panNo,
        dateOfBirth: account.dateOfBirth,
        gender: account.gender
      }
    });
  }
}
