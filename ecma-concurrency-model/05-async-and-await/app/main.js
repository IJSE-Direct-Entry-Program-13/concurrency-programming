function promiseExecutor(res, rej){
    console.log("Started to execute the promise");
    setTimeout(() => {
        rej(10);
    }, 2000);
}

console.log("Before creating the promise");
try {
    const ref = new Promise(promiseExecutor);
    const value = await ref;
    console.log(`Resolve value ${value}`);
}catch(e){
    console.log(`Rejected value ${e}`);
}finally {
    console.log("Whatever");
}
console.log("After creating the promise");

// ref.then(value => console.log(`Promise resolved1 with the value ${value}`))
//     .catch(err => console.log(`Promise rejected1 with an error ${err}`))
//     .finally(() => console.log("Whatever1"));
//

// ref.then(value => console.log(`Promise resolved2 with the value ${value}`))
//     .catch(err => console.log(`Promise rejected2 with an error ${err}`))
//     .finally(() => console.log("Whatever2"));
