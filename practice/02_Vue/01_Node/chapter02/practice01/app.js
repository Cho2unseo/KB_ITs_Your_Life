import { order } from './order.js'

let flag = 0;
for (let i in order) {
    if ('삼겹살' in order[i]) {
        flag = 1;
        console.log("✅ 삼겹살 주문 수량: " + order[i].삼겹살);
    }
}
if (flag == 0) console.log('❌ 삼겹살 주문 내역이 없습니다.');
