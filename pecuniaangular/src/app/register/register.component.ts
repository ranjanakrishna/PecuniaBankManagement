import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message: string;
  constructor(private pecuniaservice: PecuniaService) { }

  ngOnInit() {
  }

  register(form: NgForm) {
    this.pecuniaservice.register(form.value).subscribe(data => {
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
