const fs = require('fs');

if (!fs.existsSync('./text-2.txt')) {
    console.log('file does not exist');
} else {
    fs.unlinkSync('./text-2.txt', (err) => {
        if (err) {
            return console.error(err);
        }
        console.log('file deleted');
    });
}