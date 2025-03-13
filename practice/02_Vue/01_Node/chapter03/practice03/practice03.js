const fs = require('fs');

fs.readFile('./logs/members.txt', 'utf-8', (err, data) => {
    if (err) {
        return console.log('회원 정보 파일이 없습니다.');
    }
    fs.appendFile('./logs/members.txt', '\n이승기: 체중 68kg, 벤치프레스 80kg', (err) => {
        if (err) {
            return console.log(err);
        }
        console.log('회원 정보가 성공적으로 추가되었습니다.');
    })
})

// fs.readFile('./logs/members.txt', 'utf-8', (err, data) => {
//     if (err) {
//         return console.log('회원 정보 파일이 없습니다.');
//     }
//     console.log(data);
// })