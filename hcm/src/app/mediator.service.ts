import { Injectable } from '@angular/core';
import { Employee } from './employee';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MediatorService {
  e:Employee | null;
  searchResults:Employee[]=[];

  constructor() {
    this.e=null;
   }

  acceptEmployee(e:Employee)
  {
    this.e=e;
  }

  signOut()
  {
    this.e=null;
  }

  // searchEmployeeByName(employeeName:string)
  // {
  //   return this.http.get<Employee>("")
  // }
}
