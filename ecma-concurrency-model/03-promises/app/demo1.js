function promiseExecutor(res, rej){
    setTimeout(()=>{
        res(10);
    }, 1000);
}

const ref = new Promise(promiseExecutor);

ref.then(value => console.log(`Promise Resolved 1 ${value}`))
    .then(value => console.log(`Promise Resolved 2 ${value}`));