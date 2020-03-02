import {Time} from "@angular/common";
import {Employee} from "../Employee";
import {Sector} from "../sectors/Sector";
import {Pool} from "../Pool";

export class Activity {
 id:number;
 nameActivity:string;
 dataCal: Date;
 start:Time;
 end: Time;
 state: string;  //public,private
  responsableAct: Employee;
  poolActivity: Pool;

  constructor(id:number,
  nameActivity:string,
  dataCal: Date,
  start:Time,
  end: Time,
  state: string, responsableAct: Employee,  poolActivity: Pool)
  {
    this.id = id;
    this.nameActivity = nameActivity;
    this.dataCal = dataCal;
    this.start= start;
    this.end=  end;
    this.state= state;
    this.responsableAct = responsableAct;
    this.poolActivity = poolActivity;
  }
}
