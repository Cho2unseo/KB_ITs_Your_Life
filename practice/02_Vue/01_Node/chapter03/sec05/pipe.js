const fs = require('fs');

const rs = fs.createReadStream('./readMe.txt', 'utf8');
const ws = fs.createWriteStream('./writeMe.txt');

// pipe를 이용하면 여러 개의 스트림을 이어서 처리 가능
rs.pipe(ws);