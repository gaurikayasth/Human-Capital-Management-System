import { Component } from '@angular/core';
import { Employee } from '../employee';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { MediatorService } from '../mediator.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
  url:string="http://localhost:8080/signin";
  e1:Employee=new Employee();
  invalidLoginFlag:boolean=false;

  constructor(private http:HttpClient,private router:Router,private service:MediatorService)
  {

  }

  sign(signInForm:any)
  {
    // console.log(signInForm.form.value)

    this.http.post<Employee>(this.url,this.e1).subscribe(
      (next)=>{
        if(next==null)
        {
          this.router.navigateByUrl('/signin')
          this.invalidLoginFlag=true;
        }
        else
        {
          this.router.navigateByUrl('/manage');
          this.service.acceptEmployee(next);
          this.invalidLoginFlag=false;
        }
      }
    )
    
  }
}
