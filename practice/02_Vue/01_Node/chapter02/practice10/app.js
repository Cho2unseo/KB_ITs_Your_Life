import { calculateDiscount as discount } from './discount.js';

let total = discount(15000, 5);
console.log(`✅ 최종 결제 금액: ${total}원`);
