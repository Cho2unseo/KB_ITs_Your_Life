class Pet {
  constructor(name, species, vaccinations, healthCheckDate, alreadyWarned) {
    this.name = name;
    this.species = species;
    this.vaccinations = [vaccinations];
    this.healthCheckDate = healthCheckDate;
    this.alreadyWarned = false;
  }
  addVaccination(name) {
    if (this.vaccinations.includes(name))
      console.log(
        `[예방접종 중복] ${this.name}: ${name}은 이미 등록되어 있습니다.`
      );
    else {
      this.vaccinations.push(name);
      console.log(`[예방접종 추가] ${this.name}: ${name}`);
    }
  }
  updateHealthCheckDate(date) {
    this.healthCheckDate = date.toDateString();
    console.log(`[건강검진 업데이트] ${this.name}: ${this.healthCheckDate}`);
  }
}

class PetHealthManager {
  registerPet(Pet) {
    console.log(
      `[등록] ${Pet.name} - ${Pet.species} (예방접종: [${
        Pet.vaccinations
      }], 건강검진: ${Pet.healthCheckDate.toDateString()})`
    );
  }
  checkHealthStatus(pet) {
    const check = setInterval(() => {
      const d1 = new Date();
      const d2 = new Date(pet.healthCheckDate);
      if (
        Math.abs((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24)) >=
          365 &&
        !pet.alreadyWarned
      ) {
        console.log(
          `[건강검진 경고] ${pet.name}: 1년 이상 건강검진을 받지 않았습니다!`
        );
        this.alreadyWarned = true;
      }
    }, 3000);
    setTimeout(() => {
      clearInterval(check);
      console.log('[검사 종료]');
    }, 10000);
  }
}

const manager = new PetHealthManager();
const pet1 = new Pet('나비', '고양이', '종합백신', new Date('2023-03-10'));
manager.registerPet(pet1);
pet1.addVaccination('광견병');
pet1.addVaccination('광견병');
manager.checkHealthStatus(pet1);
setTimeout(() => {
  pet1.updateHealthCheckDate(new Date());
}, 5000);
