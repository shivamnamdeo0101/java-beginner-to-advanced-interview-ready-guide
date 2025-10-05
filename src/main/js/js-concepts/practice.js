//Event loop in js
//1 call stack -> web/node api -> microtask -> macrotask
console.log("start")  //sync

const interval = setInterval(()=>{ // after 5ms print shivam
    console.log("shivam")
},5)

setTimeout(()=>{     // last bcz macro task
    console.log("Timeout")
},11)

setTimeout(()=>{
    clearInterval(interval)
},5)

/* Output
start
shivam
shivam
Timeout
*/

//2.Hoisting in js
var a;
console.log(a)  //undefined - as hoised putting declaration at top
                //Not initialization
console.log(b)  //undefined
var b;

var a=1;
console.log(a)  //dec and ini so val=1 op
console.log(b)  //dec and ini in bottom so undefined
var b=10;

var b;
console.log(b,"dec top ini down")
b=10;

//Hoisting in js
//const a; //Error - Missing initializer in const declaration
// as hoised putting declaration at top
                //Not initialization

//Missing initializer in const declaration
//console.log(b)  //BE not defined
//const b; //Error - Missing initializer in const declaration

const c=1;
console.log(c)  //dec and ini so val=1 op
//console.log(d)  //dec and ini in bottom so undefined -
//const d=10;     //Cannot access 'd' before initialization

//const e; //e not defined Missing initializer in const declaration
//console.log(e,"dec top ini down")
//e=10;


//Hoisting for let
// console.log(a) -- Cannot access 'a' before initialization
let a;
console.log(a)  // undefined
a = 10;
console.log(a) //10

let b = a
console.log(b) //10
console.log(a) //10

let c;
console.log(c,"c") //undefined
c = 10;
console.log(c,"c") //10


//3. Arrow functions
function Person(name) {
    this.name = name;

    //take the this.name
    ()=>{
        // Regular functions get their this from how they are called.
        // Arrow functions capture this lexically (from the surrounding scope)
    }
    //Arrow function
    setTimeout(()=> {
        console.log("Hello " + this.name);
    }, 1000);

    //traditional
    setTimeout(function(){
        console.log("Hello " + this.name); //undefined
    }, 1000);

    //using self
    const self = this;
    setTimeout(function() {
        console.log("Hello " + self.name);
    }, 1000);

    //using bind
    setTimeout(function() {
        console.log("Hello " + this.name);
    }.bind(this), 1000);

}

const p = new Person("Shivam");

//-------------------------------------------//
// Shorter syntax → easy for callbacks
const arr = [1,2,3];
const double = arr.map(function(n){ //map will return a new arr
    return n*2;
})
console.log(double)
console.log(arr)
arr.forEach((n)=>console.log(n)) // perform operation on each n
const arr2 = arr.map((n)=> n*2)
console.log(arr2)

//4. Generators functions

//You don’t want to load/process everything upfront.
//You need lazy execution.
//You want pause/resume workflows.


function* signUpFlow(){
    const name =  yield "Enter your name";
    const email = yield "Enter your email";
    const contact = yield "Enter your contact";
    
    return `Hello Signup flow done ${name} ${email} ${contact}`
}

const flow = signUpFlow();

console.log(flow.next().value);              // "Enter your name"
console.log(flow.next("Shivam").value);      // "Enter your email"
console.log(flow.next("shivam@gmail.com").value); // "Enter your contact"
console.log(flow.next("7828353784").value);  // "Hello Signup flow done Shivam shivam@gmail.com 7828353784"


const readline = require("readline");

// Generator for signup flow
function* signUpFlow() {
    const name = yield "Enter your name:";
    const email = yield "Enter your email:";
    const contact = yield "Enter your contact:";
    return `✅ Signup complete! Hello ${name}, your email is ${email}, and contact is ${contact}`;
}

// Setup readline interface
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const flow = signUpFlow();

// Helper function to run generator interactively
function ask(question) {
    rl.question(question + " ", answer => {
        const { value, done } = flow.next(answer);
        if (!done) {
            ask(value); // ask next question
        } else {
            console.log(value); // final return message
            rl.close();
        }
    });
}

// Start flow (first .next() to get first question)
ask(flow.next().value);








