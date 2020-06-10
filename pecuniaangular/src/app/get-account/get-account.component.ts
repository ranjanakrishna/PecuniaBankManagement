import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-account',
  templateUrl: './get-account.component.html',
  styleUrls: ['./get-account.component.css']
})
export class GetAccountComponent implements OnInit {
  message: string;
  accounts: Account[];
  selectedAccountToUpdate: Account;

  constructor(private pecuniaservice: PecuniaService,
    private router: Router) {
    this.getAccount();
  }

  ngOnInit() {
  }

  getAccount() {
    this.pecuniaservice.getAccount().subscribe(response => {
      console.log(response);
      this.accounts = response.beans;
    }, err => {
      console.log(err);
    });
  }

  deleteAccount(account) {
    this.pecuniaservice.deleteAccount(account).subscribe(response => {
      console.log(response);
      if (response.statusCode === 200) {
        this.accounts.splice(this.accounts.indexOf(account), 1);
      }
    });
  }

  updateAccount(account) {
    this.router.navigate([`update-account/${account.accountNo}`],
      {
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

  isEmployee() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    if (userDetails && userDetails.beans[0].userType === 'employee') {
      return true;
    } else {
      return false;
    }
  }


}
