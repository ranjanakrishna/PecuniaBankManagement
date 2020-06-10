import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.css']
})
export class AddAccountComponent implements OnInit {

  message: string;
  constructor(private pecuniaservice: PecuniaService) {

  }

  ngOnInit() {
  }

  addAccount(form: NgForm) {
    this.pecuniaservice.addAccount(form.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
      form.reset();
    }, err => {
      console.log(err);
    });
  }

}
