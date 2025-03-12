import { grillMeat } from './grill.js';

async function startGrilling() {
  try {
    const response = await grillMeat('삼겹살');
    console.log("🍽️ 식사 시작!");
  } catch (err) {
    console.error(err);
  }
}

startGrilling();
