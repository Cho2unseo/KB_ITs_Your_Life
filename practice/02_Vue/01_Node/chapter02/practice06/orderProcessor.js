import { orders } from './orderList.js';

const calculatorTotal = (order) => {
  return new Promise((resolve, reject) => {
    var menus = {};
    order.forEach(({ name, quantity }) => {
      if (name in menus) {
        menus[name] += quantity - '0';
      } else menus[name] = quantity - '0';
    });
    resolve(menus);
  });
};

const isTopMenu = async (menuname) => {
  const menus = await calculatorTotal(orders);
  var max = 0;
  var menun = '';
  Object.entries(menus).forEach(([name, quantity]) => {
    if (quantity > max) {
      max = quantity;
      menun = name;
    }
    // console.log(quantity);
  });
  return menun == menuname;
};

export { calculatorTotal, isTopMenu };
