class PetPhoto {
  constructor(name, species, adoptionDate, photoPath) {
    this.name = name;
    this.species = species;
    this.adoptionDate = adoptionDate;
    this.photoPath = photoPath;
    this.uploadDate = new Date();
    this.type = 'Photo';
  }
}

export { PetPhoto };
