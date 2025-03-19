import fs from 'fs/promises';

async function checkIn(name) {
  const names = [];
  try {
    const check = await fs.readFile('./logs/checkin.txt', 'utf-8');
    const lines = check.split('\n').filter((line) => line.trim());
    const names = lines.map((line) => line.split(':')[0]);
    // console.log(names);
    console.log('출석 중...');
    const year = new Date().getFullYear();
    const month = new Date().getMonth() + 1;
    const day = new Date().getDate();
    if (names.includes(name)) {
      console.log(`${name} 회원님은 이미 출석하셨습니다!`);
    } else {
      setTimeout(() => {
        console.log(
          `${name}: 출석 완료 (${year}-${String(month).padStart(
            2,
            '0'
          )}-${String(day).padStart(
            2,
            '0'
          )} ${new Date().getHours()}:${new Date().getMinutes()})`
        );
        console.log('출석 기록이 파일에 저장되었습니다!');
      }, 1000);
      const data = await fs.appendFile(
        './logs/checkin.txt',
        `${name}: 출석 완료 (${year}-${String(month).padStart(2, '0')}-${String(
          day
        ).padStart(
          2,
          '0'
        )} ${new Date().getHours()}:${new Date().getMinutes()})\n`
      );
      names.push(name);
    }
  } catch (err) {
    console.error(err);
  }
}

checkIn('이승기');
