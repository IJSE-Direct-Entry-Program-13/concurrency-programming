const ref1 = new Promise(function(res, rej){
   if (Math.random() < 0.5) res(10);
   else res(20);
});

// Promise (Definition) => async
const ref2 = async function myFn1(){
    if (Math.random() < 0.5) return 10;
    else return "Invalid value";
}

// Promise (Listening) => await
try {
    const value = await ref2();
    console.log(value);
}catch(e) {
    console.log(e);
}

ref1.then(value => console.log(value))
    .catch(err => console.log(err));