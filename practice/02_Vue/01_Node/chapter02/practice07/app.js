import { processOrder } from "./orderProcessor.js";

const orders = [
  { name: '삼겹살', quantity: '2' },
  { name: ' 목살', quantity: '3' },
  { name: '갈비', quantity: '1' },
  { name: '항정살', quantity: '4' },
];

async function processAllOrders(order) {
    try {
        for (let i of order) {
            const result = await processOrder(i);
            console.log(result);
        }
    } catch (err) {
        console.error(err);
    }
}

processAllOrders(orders);