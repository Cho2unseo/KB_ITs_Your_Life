const fs = require('fs');

if (fs.existsSync('./test')) {
    // 해당 폴더가 있으면
    console.log('folder already exists');
} else {
    // mkdir : 해당 경로의 폴더를 비동기적으로 생성
    fs.mkdir('./test', (err) => {
        if (err) {
            return console.error(err);
        }
        console.log('folder created');
    })
}