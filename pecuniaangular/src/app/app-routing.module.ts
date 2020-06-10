import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddAccountComponent } from './add-account/add-account.component';
import { UpdateAccountComponent } from './update-account/update-account.component';
import { GetAccountComponent } from './get-account/get-account.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { UpdatePasswordComponent } from './update-password/update-password.component';
import { SearchAccountComponent } from './search-account/search-account.component';



const routes: Routes = [
  {
    path: '', component: HomeComponent
  }, {
    path: 'add-account',
    component: AddAccountComponent
  }, {
    path: 'update-account/:accountNo',
    component: UpdateAccountComponent
  }, {
    path: 'get-account',
    component: GetAccountComponent
  },{
    path: 'search-account/:accountNo',
    component: SearchAccountComponent
  }, {
    path: 'register-user',
    component: RegisterComponent
  }, {
    path: 'login-user',
    component: LoginComponent
  }, {
    path: 'update-password',
    component: UpdatePasswordComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
