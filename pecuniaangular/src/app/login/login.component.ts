import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  response: Response;
  message: string;

  constructor(private pecuniaservice: PecuniaService,
    private router: Router) { }

  ngOnInit() {
  }

  login(form: NgForm) {
    this.pecuniaservice.login(form.value).subscribe(data => {
      console.log(data);
      this.response = data;
      this.message = this.response.description;
      if (this.response.statusCode === 200) {
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('user details stored in local storage');
        this.router.navigateByUrl('');
      }
    }, err => {
      console.log(err);
      this.message = err.error.message;
      setTimeout(() => {
        this.message = null;
      }, 2000);
    });
  }
    



}
