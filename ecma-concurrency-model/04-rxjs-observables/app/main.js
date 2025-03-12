import {finalize, Observable} from "rxjs";

function executor(subscriber) {
    console.log("Start executing the observable");
    setInterval(() => {
        subscriber.next();
        subscriber.complete();
    }, 2000);
}

console.log("About to create an observable");
const ref = new Observable(executor);
console.log("Just created an observable");
ref.pipe(finalize(() => {
        console.log("Nawa gilunath ban choon");
    })).subscribe({
        next: (value) => {
            console.log("Hooray...!");
        },
        error: (err) => {
            console.log("Pelapali");
        }
    })


