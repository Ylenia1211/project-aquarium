import {Employee} from "./Employee";

export class Pool {
  idPool: number
  namePool: string
  volume: string
  state: string
  responsable: Employee
  //private Set<Employee> responsableList = new HashSet<>();
  constructor( idPool: number,  namePool: string, state: string,  responsable: Employee) {
    this.idPool = idPool;
    this.namePool = namePool;
    this.state = state;
    this.responsable = responsable;
  }
}
