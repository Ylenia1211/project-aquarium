export class Animal {
  id: number
  name: string
  species: string
  sex:string

  constructor(id: number, name: string, species: string, sex:string) {
    this.id = id;
    this.name = name;
    this.species = species;
    this.sex = sex;
  }
}
