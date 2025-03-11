console.log("2 + 3 = " + add1(2, 3));
console.log("4 + 5 = " + add2(4, 5)); // 에러

// 함수선언식, 이것만 호이스팅됨
function add1(a, b) { return a + b; }
// 함수표현식
var add2 = function(a, b) { return a + b; };