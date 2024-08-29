import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { HttpClient } from '@angular/common/http';
import { Skill } from '../skill';

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent{
  allEmployees:Employee[]=[];
  skillsByEmployee:Skill[]=[]

  constructor(private http:HttpClient)//HttpClient is a built in service to connect with backend
  {
    this.getEmployees();
  }
  
  getEmployees()
  {
    this.http.get<Employee[]>("http://localhost:8080/employee").subscribe(
      (next)=>{console.log(next);this.allEmployees=next}
    )
  }

  getSkillsByEmployee(employeeId:number)
  {
    this.http.get<Skill[]>("http://localhost:8080/skill/skills/"+employeeId).subscribe(
      (next)=>{console.log(next);this.skillsByEmployee=next}
    )
  }
}
