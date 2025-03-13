const fs = require('fs');
const path = require('path');

fs.mkdir('./members', (err) => {
  if (err) {
    return console.error(err);
  }
  fs.writeFile(
    './members/kim_jong_kook.txt',
    '김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg',
    (err) => {
      if (err) {
        return console.error(err);
      }
      fs.readFile('./members/kim_jong_kook.txt', 'utf-8', (err) => {
        if (err) {
          return console.log(err);
        }
        const filePath = path.join(__dirname, 'members', 'kim_jong_kook.txt');
        console.log('파일 생성 완료!');
        console.log('디렉터리 경로: ' + path.basename(path.dirname(filePath)));
        console.log('파일 이름: ' + path.basename(filePath));
        console.log('파일 확장자: ' + path.extname(filePath));
        console.log(
          '파일 이름(확장자 제외): ' + path.basename(filePath, '.txt')
        );
      });
    }
  );
});
