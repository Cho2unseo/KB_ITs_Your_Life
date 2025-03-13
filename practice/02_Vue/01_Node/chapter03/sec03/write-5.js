const fs = require('fs');

// appendFile : 비동기로 기존 파일 내용에 새로운 내용을 추가
// flag 옵션을 a로 준 것과 동일하게 동작한다.
fs.appendFile('./text-2.txt', '\n\n 새로운 내용 추가', (err) => {
    if (err) {
        return console.log(err);
    }
    console.log('appending to file');
})