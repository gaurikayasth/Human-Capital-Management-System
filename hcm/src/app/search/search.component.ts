import { Component } from '@angular/core';
import { MediatorService } from '../mediator.service';
import { Skill } from '../skill';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  skillsByEmployee:Skill[]=[]

  constructor(public service:MediatorService,private http:HttpClient)
  {

  }

  getSkillsByEmployee(employeeId:number)
  {
    this.http.get<Skill[]>("http://localhost:8080/skill/skills/"+employeeId).subscribe(
      (next)=>{console.log(next);this.skillsByEmployee=next}
    )
  }
}
