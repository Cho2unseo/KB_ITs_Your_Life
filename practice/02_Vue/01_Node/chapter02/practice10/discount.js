const calculateDiscount = (price, quantity) => {
  let total = 0;
  if (quantity >= 5) total = price * quantity * 0.9;
  else total = price * quantity;
  return total;
};

export { calculateDiscount };