import {
  isTopMenu as isTop,
  calculatorTotal as calc,
} from './orderProcessor.js';
import { orders } from './orderList.js';

async function print() {
  try {
    const response = await calc(orders);
    console.log('✅ 총 주문 수량: ' + JSON.stringify(response));
    const response1 = await isTop('목살');
    console.log(
      '🥩 목살이 가장 인기 메뉴인가요? ' + (response1 ? '네!' : '아니오!')
    );
  } catch (err) {
    console.error(err);
  }
}

print();
