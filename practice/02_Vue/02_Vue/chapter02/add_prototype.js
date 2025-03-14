/*
const eunseo = {
    firstName : 'eunseo',
    lastName : 'choi',
    getFullName : function() {
        return `${this.firstName} ${this.lastName}`;
    }
}
// 일반 함수에서 this는 호출한 객체
console.log(eunseo.getFullName());
*/

// 생성자 함수
function User(first, last) {
  this.firstName = first;
  this.lastName = last;
}

// 프로토타입에 추가된 함수는 객체 전체가 공유한다.
User.prototype.getFullName = function () {
  return `${this.firstName} ${this.lastName}`;
};

const eunseo = new user('eunseo', 'choi');
const riku = new user('陆', '前田');

console.log(eunseo.getFullName());
console.log(riku.getFullName());
