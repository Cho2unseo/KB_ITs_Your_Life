const runStretching = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('스트레칭 완료');
            resolve();
        }, 1000);
    });
};

const runTreadmill = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('러닝머신 완료');
            resolve();
        }, 500);
    });
};

const runProtein = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('단백질 보충 완료');
            resolve();
        }, 0);
    });
};


async function exercise() {
    try {
        const res = await runStretching;
        const rt = await runTreadmill;
        const rp = await runProtein;
        console.log('운동 기록 처리 종료');
    } catch (err) {
        return console.error(err);
    }
} 

exercise();