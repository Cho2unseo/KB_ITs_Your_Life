function outer() {
    var value = 1234;
}
// 함수 내부에 있는 값을 가져오기 때문에 에러
outer();
console.log("value = " + value);