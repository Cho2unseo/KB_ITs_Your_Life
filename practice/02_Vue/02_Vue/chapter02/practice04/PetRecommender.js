import fs from 'fs/promises';

class PetRecommender {
  constructor() {
    this.pets = [];
  }
  recommendPet(customer) {
    let pet = '';
    if (customer.lifestyle == '활동적') {
      pet = '골든 리트리버';
    } else pet = '고양이';
    this.pets.push({ name: customer.name, recommendedPet: pet });
    // console.log(this.pets);
  }
  async saveToFile() {
    try {
      await fs.writeFile('./pet_recommendations.json', JSON.stringify(this.pets, null, 2));
    } catch (err) {
      console.error(err);
    }
  }
}

export { PetRecommender };
