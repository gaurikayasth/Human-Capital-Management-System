import { Component } from '@angular/core';
import { Department } from '../department';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../employee';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrls: ['./departments.component.css']
})
export class DepartmentsComponent {

  allDepartments:Department[]=[];
  employeesByDepartment:Employee[]=[];

  constructor(private http:HttpClient)
  {
    this.getDepartments();
  }

  getDepartments()
  {
    this.http.get<Department[]>("http://localhost:8080/department").subscribe(
      (next)=>{console.log(next);this.allDepartments=next}
    )
  }

  getEmployeesByDepartment(departmentId:number)
  {
    this.http.get<Employee[]>("http://localhost:8080/employee/departments/"+departmentId).subscribe(
      (next)=>{console.log(next);this.employeesByDepartment=next}
    )
  }

}
