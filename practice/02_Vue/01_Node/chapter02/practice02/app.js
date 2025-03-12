import { addOrder, order } from './orderManager.js';

addOrder('삼겹살', '3인분');
addOrder('목살', '2인분');

console.log('✅ 현재 주문 내역:');
if (order.length == 0) console.log('❌ 주문 내역이 없습니다.');
else {
  for (let i in order) {
    console.log(order[i].menu + ': ' + order[i].quantity);
  }
}
