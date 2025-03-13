const fs = require('fs');

fs.readFile('example.txt', (err, data) => {
    if (err) return console.log(err);

    console.log(data); // 기본값은 이진 데이터로 출력
    console.log('\n');
    // toString 사용해서 문자열로 변환 가능
    console.log(data.toString());
})