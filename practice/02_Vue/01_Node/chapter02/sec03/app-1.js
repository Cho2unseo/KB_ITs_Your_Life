// 다른 js 파일에서 export 한 모듈 가져오기
// commonJS의 가져오기 방식

const user = require('./user');
const hello = require('./hello');

console.log(user);
console.log(hello);

hello(user);