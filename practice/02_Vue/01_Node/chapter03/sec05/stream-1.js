const fs = require('fs');

// createReadStream : ReadStream 생성
const rs = fs.createReadStream('./example.txt');

// data : 데이터가 읽힐 때마다 발생하는 이벤트
rs.on('data', (chunk) => {
  console.log('new chunk received: ');
  console.log(chunk.length, chunk);
})
  .on('end', () => { // 데이터 읽기가 완료됐을 때 발생하는 이벤트
    console.log('finished reading data');
  })
  .on('error', (err) => {
    console.error(`Error reading the file: ${err}`);
  });
