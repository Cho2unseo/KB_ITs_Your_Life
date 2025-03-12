const order = [];

const addOrder = (menu, quantity) => {
    order.push({menu, quantity});
};

export { order, addOrder };