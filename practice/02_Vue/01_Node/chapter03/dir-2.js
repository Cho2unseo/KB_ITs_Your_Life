const fs = require('fs');

if (fs.existsSync('./test2/test3/test4')) {
    console.log('folder already exists');
} else {
    // recursive 옵션을 사용하면 중간 경로에 있는 폴더까지 생성 가능
    fs.mkdir('./test2/test3/test4', { recursive: true }, (err) => {
        if (err) {
            return console.error(err);
        }
        console.log('folder created');
    })
}