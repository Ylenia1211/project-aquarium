export class Specie{
  idSpecies: number
  nameSpecies: string
  description: string
  numberAnimals: number

  constructor(idSpecies: number, nameSpecies: string, description: string, numberAnimals: number) {
    this.idSpecies = idSpecies;
    this.nameSpecies = nameSpecies;
    this.description = description;
    this.numberAnimals = numberAnimals;
  }
}


