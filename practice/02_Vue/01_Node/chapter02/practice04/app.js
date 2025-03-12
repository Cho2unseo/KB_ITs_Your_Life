import { processOrder } from './orderProcess.js';

async function processOrders() {
  try {
    const response1 = await processOrder({ menu: '삼겹살', quantity: '2' });
    const response2 = await processOrder({ menu: '목살', quantity: '3' });
    const response = await processOrder({ menu: '갈비', quantity: '1' });
    console.log('🍽️ 모든 주문 처리 완료! 식사 시작!');
  } catch (err) {
    console.error(err);
  }
}

processOrders();
