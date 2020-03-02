import {Time} from "@angular/common";

export class Activity {
 id:number;
 nameActivity:string;
 dataCal: Date;
 start:Time;
 end: Time;
 state: string;  //public,private

  constructor(id:number,
  nameActivity:string,
  dataCal: Date,
  start:Time,
  end: Time,
  state: string)
  {
    this.id = id;
    this.nameActivity = nameActivity;
    this.dataCal = dataCal;
    this.start= start;
    this.end=  end;
    this.state= state;
  }
}
