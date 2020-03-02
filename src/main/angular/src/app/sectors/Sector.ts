import {Employee} from "../Employee";
import {Pool} from "../Pool";

export class Sector {
  id: number
  name: string
  localitation: string
  sectorPools: Array<Pool>

  constructor(id: number, name: string, localitation: string,  sectorPools: Array<Pool>) {
    this.id = id;
    this.name = name;
    this.localitation = localitation;
    this.sectorPools = sectorPools;
  }
}
