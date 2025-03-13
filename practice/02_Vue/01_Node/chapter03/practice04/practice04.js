const fs = require('fs');

const ws = fs
  .ReadStream('./logs/workout_log.txt')
  .pipe(fs.WriteStream('./logs/backup_log.txt'));

ws.on('finish', () => {
  console.log('백업이 완료되었습니다.');
}).on('error', (err) => {
  console.error(`백업 중 오류가 발생했습니다. ${err}`);
});
