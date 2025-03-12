const grillMeat = (menu) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log('🔥 ' + menu + '가 다 구워졌습니다!');
      resolve();
    }, 2000);
  });
};

export { grillMeat };
