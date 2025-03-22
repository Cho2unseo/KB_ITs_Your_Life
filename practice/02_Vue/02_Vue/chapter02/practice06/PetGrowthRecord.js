class PetGrowthRecord {
  constructor(name, species, adoptionDate, description, recordDate) {
    this.name = name;
    this.species = species;
    this.adoptionDate = adoptionDate;
    this.description = description;
    this.recordDate = recordDate;
    this.type = 'Growth Record';
  }
}

export { PetGrowthRecord };
