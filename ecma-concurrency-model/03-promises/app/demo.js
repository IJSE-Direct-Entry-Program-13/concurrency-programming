function promiseExecutor(res, rej){
    console.log("Start executing the promise");
    setTimeout(() => {
        res(10);
    }, 5000);
}
const ref = new Promise(promiseExecutor);   // Initial Promise

const ref2 = ref.then(value =>{
    console.log(`Promise Resolved with value ${value} 👍`);
    return true;
});

ref2.then(value => console.log(value));
ref2.then(value => console.log(value));
ref2.then(value => console.log(value));

ref.then(value => console.log(value));
ref.then(value => console.log(value));