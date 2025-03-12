setTimeout(function () {
    console.log("Welcome");
}, 8000);

const value = await new Promise(function(res, rej){
    setTimeout(()=>{
        res(10)
    }, 5000);
});

console.log(value);
