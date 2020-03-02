import {Pool} from "./Pool";

export class Employee {
  idEmployee: number
  name: string
  designation: string
  surname: string
  numSecSocial: string;
  birthday: Date;
  poolResponsable: Array<Pool>;


  constructor(idEmployee: number, name: string, designation: string, surname: string, numSecSocial: string,  birthday: Date, poolResponsable: Array<Pool>) {
    this.idEmployee = idEmployee;
    this.name = name;
    this.designation = designation;
    this.surname = surname;
    this.numSecSocial = numSecSocial;
    this.birthday = birthday;
    this.poolResponsable = poolResponsable;
  }
}
