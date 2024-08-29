import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { MediatorService } from '../mediator.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  empName:string="";

  constructor(private http:HttpClient,private router:Router,public service:MediatorService)
  {

  }

  searchByName(searchForm:any)
  {
    this.http.get<Employee[]>("http://localhost:8080/employee/find/"+this.empName).subscribe(
      (next)=>{console.log(next);
        this.service.searchResults=next;
        this.router.navigateByUrl("/search");
      }
    )
  }

}
