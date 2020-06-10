import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {

  accountNo1;
  customerName1;
  address1;
  city1;
  state1;
  country1;
  phoneNo1;
  aadhaarNo1;
  panNo1;
  dateOfBirth1;
  gender1;

  message: string;

  constructor(public pecuniaservice: PecuniaService,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
          activatedRoute.params.subscribe(data=>{
            this.accountNo1=data.accountNo;
                });

          activatedRoute.queryParams.subscribe(data=>{
            this.customerName1=data.customerName;
            this.address1=data.address;
            this.city1=data.city;
            this.state1=data.state;
            this.country1=data.country;
            this.phoneNo1=data.phoneNo;
            this.aadhaarNo1=data.aadhaarNo;
            this.panNo1=data.panNo;
            this.dateOfBirth1=data.dateOfBirth;
            this.gender1=data.gender;
          });
    }

    response: Response;

    updateAccount(form: NgForm){
      console.log(form.value);
      this.pecuniaservice.updateAccount(form.value).subscribe(data=>{
        console.log(data);
        this.router.navigateByUrl('get-account');
      });
    }

  ngOnInit() {
  }

}
