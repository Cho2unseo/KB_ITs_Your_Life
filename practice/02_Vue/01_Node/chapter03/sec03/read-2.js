const fs = require('fs');

// encoding 옵션으로 utf-8 형식으로 변경

const data = fs.readFileSync('./example.txt', 'utf-8');
console.log(data);