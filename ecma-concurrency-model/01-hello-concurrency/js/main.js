alert("Let's start");

const clickHandler = function(){
    alert("Someone clicked!");
};

document.querySelector("#btn-click")
.addEventListener('click', clickHandler);

console.log("Event listener added");

sleep(20000);

function sleep(ms){
    const t = Date.now();
    while (Date.now() - t < ms) console.log("Sleep");
}