import {createServer} from "node:http";

let count = 0;

const server = createServer(async function(req, res){
    res.end(`<h1>Hello ${count++}</h1>`);
    if (count === 2){
        sleep(20000);
    }
});

function sleep(ms){
    const t1 = Date.now();
    while (Date.now() - t1 < ms);
}

server.listen(7070);


