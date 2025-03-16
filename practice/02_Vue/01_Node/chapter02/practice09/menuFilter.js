const filterMenuByPrice = (menu, maxPrice) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      let array = menu.filter((value) => value.price <= maxPrice);
      // console.log(menu);
      resolve(array);
    }, 1000);
  });
};

export { filterMenuByPrice };