const processOrder = (order) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log(
        '✅ ' + order.menu + ' ' + order.quantity + '인분 주문 처리 완료!'
      );
      resolve();
    }, 1000);
  });
};

export { processOrder };
