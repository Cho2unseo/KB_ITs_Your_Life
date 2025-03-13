const fs = require('fs').promises;

const processFile = async () => {
    // 1. 파일 생성
    try {
        await fs.writeFile('./example.txt', 'Hello, Node.js!');
        // await 뒤에는 Promise 객체만 올 수 있다
        console.log('파일이 생성되었습니다.');
    
        // 2. 파일 읽기
        const data = await fs.readFile('./example.txt', 'utf-8');
        console.log('파일 내용: ', data);
    
        // 3. 파일에 내용 추가
        await fs.appendFile('./example.txt', '\n추가된 내용입니다.');
        console.log('파일에 내용이 추가되었습니다.');
    
        // 4. 파일 삭제 
        await fs.unlink('./example.txt');
        console.log('파일이 삭제되었습니다.');
    } catch (error) {
        console.log('에러 발생');
    }
    
}

processFile();