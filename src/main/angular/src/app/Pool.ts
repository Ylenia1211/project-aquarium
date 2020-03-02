import {Employee} from "./Employee";
import {Sector} from "./sectors/Sector";

export class Pool {
  idPool: number
  namePool: string
  volume: number
  state: string
  responsable: Employee
  poolSector: Sector
  //private Set<Employee> responsableList = new HashSet<>();
  constructor( idPool: number,  namePool: string, state: string, volume:number, responsable: Employee, poolSector:Sector) {
    this.idPool = idPool;
    this.namePool = namePool;
    this.state = state;
    this.volume = volume;
    this.responsable = responsable;
    this.poolSector = poolSector;
  }
}
