class PetRecommender {
  constructor() {}
  recommendPet(customer) {
    let pet = '';
    if (customer.lifestyle == '활동적') {
      pet = '골든 리트리버';
    } else pet = '고양이';
    console.log(pet);
  }
}

export { PetRecommender };
