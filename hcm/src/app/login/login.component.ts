import { Component } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  e1:Employee=new Employee();

  save(loginForm:any)
  {
    console.log(this.e1);
  }
}
