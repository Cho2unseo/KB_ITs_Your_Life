const processOrder = (order) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (order.quantity >= 3) {
        resolve(`✅ ${order.name} ${order.quantity}인분 주문 완료!`);
      } else {
        resolve(`❌ ${order.name} ${order.quantity}인분은 주문 최소 수량 미달입니다.`);
      }
    }, 1000);
  });
};

export { processOrder };
