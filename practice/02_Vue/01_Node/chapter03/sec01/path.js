const path = require('path');

// 경로 연결하기
// join : 여러개의 경로를 받아 절대 주소로 합쳐준다.
const fullPath = path.join('some', 'work', 'ex.txt');
console.log(fullPath);

// __filename : 파일의 절대 경로
console.log(`파일 절대 경로 : ${__filename}`);

// __dirname : 해당 파일이 있는 폴더의 절대 경로
const dir = path.dirname(__filename);
console.log(`경로만 : ${dir}`);

// basename : 경로 제외한 파일명만 가져온다
const fn = path.basename(__filename);
console.log(`파일 이름 : ${fn}`);

// 확장자까지 제외 가능
const fn2 = path.basename(__filename, '.js');
console.log(`파일 이름(확장자 제외) : ${fn2}`);

// extname : 확장자만 추출
const ext = path.extname(__filename);
console.log(`파일 확장자 : ${ext}`);
console.log(path.basename(__filename, '.js'));

// parse : 경로에 대한 정보를 객체로 반환
const parsedPath = path.parse(__filename);
console.log(parsedPath);