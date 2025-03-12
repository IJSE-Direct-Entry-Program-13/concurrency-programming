console.log("Hello App!");

// Sync iterable ... Sync Iterator
for(const value of [10,20,30,40,50]){
    console.log(value);
}
const ref = new Promise(function(res, rej){
    setTimeout(() => {
        res([10,20,30,40,50]);
    }, 2000);
});
console.log("===============");
// Async iterable ... Sync Iterator
for(const value of await ref) console.log(value);

const promise1 = new Promise((res, rej)=>{
    setTimeout(() => res(10), 2000);
});
const promise2 = new Promise((res, rej)=>{
    setTimeout(() => res(20), 4000);
});
const promise3 = new Promise((res, rej)=>{
    setTimeout(() => res(30), 6000);
});
const promise4 = new Promise((res, rej)=>{
    setTimeout(() => res(40), 8000);
});
console.log("===============");
// for(const value of [promise1, promise2, promise3, promise4]){
//     console.log(await value);
// }
// for await(const value of [promise1, promise2, promise3, promise4]){
//     console.log(value);
// }
const ref2 = new Promise((resolve, reject)=>{
    setTimeout(() => {
        resolve([promise1, promise2, promise3, promise4]);
    }, 5000);
})
// for (const value of await ref2){
//     console.log(await value);
// }
for await (const value of await ref2) console.log(value);