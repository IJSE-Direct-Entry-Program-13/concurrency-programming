function promiseExecutor(res, rej){
    setTimeout(() => {
        res(10);
    }, 5000);
}

console.log("Start");
async function execute(){
    console.log("Entered into the execute");
    const value = await new Promise(promiseExecutor);
    console.log(`Resolved value: ${value}`);
}

console.log("Before execute()");
execute();
console.log("After execute()");
