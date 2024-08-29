import { Component } from '@angular/core';
import { Employee } from '../employee';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MediatorService } from '../mediator.service';
import { Status } from '../status';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  e1:Employee;
  successFlag:boolean=false;
  errorFlag:boolean=false;
  dSuccessFlag:boolean=false;
  dErrorFlag:boolean=false;
  
  constructor(private http:HttpClient,private service:MediatorService)
  {
    this.e1= new Employee();
  }

  ngOnInit()
  {
    Object.assign(this.e1,this.service.e)
  }

  profileSubmit(profileForm:any)
  {
    this.http.post<Employee>("http://localhost:8080/employee",this.e1).subscribe(
      (next)=>{console.log(next);
        if (this.e1.empId !== next.empId)
          this.errorFlag = true

        else
        {
          this.successFlag=true;
          profileForm.form.markAsPristine();
        }
  })
  }

  deleteProfile()
  {
    this.http.delete<Status>("http://localhost:8080/employee/"+this.e1?.empId).subscribe(
      (next)=>{console.log(next);
        if (next.responseStatus)
        {
          this.dSuccessFlag = true;
          this.e1=new Employee();
          this.service.signOut();
        }
        else if(!next.responseStatus)
        {
          this.dErrorFlag = true;
        }
      }
    )
  }
}
