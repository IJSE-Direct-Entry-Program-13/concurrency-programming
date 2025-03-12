function* syncGenerator() {
    yield 10;
    yield 20;
    yield 30;
}

for (const value of syncGenerator()) console.log(value);
console.log("--------");

const p1 = new Promise((res) =>
    setTimeout(() => res(10), 2000));
const p2 = new Promise((res) =>
    setTimeout(() => res(20), 4000));
const p3 = new Promise((res) =>
    setTimeout(() => res(new Promise(r =>{
        setTimeout(()=> r([10,20]), 8000);
    })), 6000));

async function* asyncGenerator(){
    yield await p1;
    yield await p2;
    yield await p3;
}

for await(const value of asyncGenerator()) console.log(value);