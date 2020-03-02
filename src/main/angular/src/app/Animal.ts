import {Pool} from "./Pool";

export class Animal {
  id: number
  name: string
  species: string
  sex:string
  feature:string;
  extinction: boolean;
  arrivalDate: Date;
  departureDate: Date;
  lifeExpectancy: number;
  dietaryRegime: number;
  threatLevel: number;
  pool: Pool;
  constructor(id: number, name: string, species: string, sex:string,
              feature:string,
              extinction: boolean,
              arrivalDate: Date,
              departureDate: Date,
              lifeExpectancy: number,
              dietaryRegime: number,
              threatLevel: number,
              pool: Pool)
  {
    this.id = id;
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.feature=  feature;
    this.extinction= extinction;
    this.arrivalDate =arrivalDate;
    this.departureDate=departureDate;
    this.lifeExpectancy=lifeExpectancy;
    this.dietaryRegime=dietaryRegime;
    this.threatLevel=threatLevel;
    this.pool = pool;
  }
}
