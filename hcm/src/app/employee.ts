export class Employee {
    empId:number;
	empName:string;
	empPhone:string;
	email:string;
	empAddress:string;
	empGender:string;
	empSalary:number;
	password:string;
	dateOfJoining:string;
	// Department department;

    constructor()
    {
		this.empId=0;
		this.empName="";
		this.empPhone="";
		this.email="";
		this.empAddress="";
		this.empGender="";
		this.empSalary=0;
		this.password="";
		this.dateOfJoining="";
    }
}
