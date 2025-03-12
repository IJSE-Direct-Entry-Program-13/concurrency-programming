function promiseExecutor(resolve, reject){
    console.log("Start executing the promise");
    // Let's act like we have something very serious work to do here
    setTimeout(()=>{
        //reject();
    }, 1000);
}
console.log("Let's create a promise")
const ref = new Promise(promiseExecutor);
console.log("Just created a promise");

setTimeout(() => {
    console.log(ref);
}, 2000);

// ref.then((value)=>{
//     console.log("Hooray 1");
// }, (err)=>{
//     console.log("Pela paali yanawa 2")
// });
// ref.then(value =>{
//     console.log("Hooray..!");
// });
// ref.catch(err =>{
//     console.log("Pela paali yanawa");
// });
// ref.finally(()=>{
//     console.log("Nawa gilunath ban choon");
// });
// ref.then(value =>{
//     console.log("Hooray..!");
// }).catch(err =>{
//     console.log("Pela paali yanawa");
// }).finally(()=>{
//     console.log("Nawa gilunath ban choon");
// });