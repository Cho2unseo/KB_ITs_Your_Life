import { orderStatus, updateStatus } from "./status.js";

async function trackStatus() {
    try {
        const response = await updateStatus('samgyeopsal', '굽는 중');
        const response1 = await updateStatus('samgyeopsal', '완료');
        const response2 = await updateStatus('galbi', '굽는 중');
        const response3 = await updateStatus('galbi', '완료');
        console.log("📋 최종 주문 상태: " + JSON.stringify(orderStatus));
    } catch (err) {
        console.error(err);
    }
}

trackStatus();