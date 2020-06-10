import { Component, OnInit } from '@angular/core';
import { PecuniaService } from '../pecunia.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent implements OnInit {

  message: string;
  constructor(private pecuniaservice: PecuniaService,
    private router: Router) { }
  response: Response;

  ngOnInit() {
  }

  updatePassword(form: NgForm) {
    this.pecuniaservice.updatePassword(form.value).subscribe(resp => {
      console.log(resp);
      this.response = resp;
      this.message = resp.description;
      if (this.response.statusCode === 200) {
        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();
        this.router.navigateByUrl('/update-password');
      }
    });
  }
}
