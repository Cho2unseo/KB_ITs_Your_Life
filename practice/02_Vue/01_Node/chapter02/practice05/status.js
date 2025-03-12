var orderStatus = { samgyeopsal: '주문 대기', galbi: '주문 대기'};

const updateStatus = (menu, status) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      orderStatus[menu] = status;  
      console.log("🔄 " + menu + " 상태가 '" +  orderStatus[menu] + "'로 변경되었습니다.");
      resolve();
    }, 1000);
  });
};

export { orderStatus, updateStatus };