// ==================== 1️⃣ Variables ====================
// Pre-ES6: var (function-scoped, hoisting issues)
var x = 10; if(true){ var x=20; } console.log(x); // 20 (leak)
// ES6+: let/const (block-scoped)
let y = 10; const z = 20; if(true){ let y=30; const z=40; } console.log(y,z); // 10,20

// ==================== 2️⃣ Functions ====================
// Pre-ES6: function loses this in callbacks
function Person1(name){
  this.name=name;
  setTimeout(function(){ console.log(this.name); },1000); // undefined
}
// ES6+: arrow function captures lexical this
function Person2(name){
  this.name=name;
  setTimeout(()=>console.log(this.name),1000); // correct
}

// Default parameters
// Pre-ES6: manual check
function greetOld(name){ name=name||"Guest"; }
// ES6+
function greet(name="Guest"){ console.log(name); }

// ==================== 3️⃣ Strings ====================
// Pre-ES6: concatenation
var msg = "Hello " + name + "!";
// ES6+: template literals
const msg2 = `Hello ${name}!`;
"hello".includes("e"); // true
"hello".startsWith("he"); // true
"hello".repeat(2); // "hellohello"

// ==================== 4️⃣ Destructuring ====================
// Pre-ES6
var arr=[1,2]; var a=arr[0]; var b=arr[1];
var obj={n:"Shivam",age:24}; var name=obj.n; var age=obj.age;
// ES6+
const [a1,b1]=[1,2];
const {n, age}={n:"Shivam", age:24};

// ==================== 5️⃣ Rest & Spread ====================
// Pre-ES6: arguments object
function sumOld(){ var s=0; for(var i=0;i<arguments.length;i++) s+=arguments[i]; }
// ES6+
function sum(...nums){ return nums.reduce((a,b)=>a+b,0); }
const arr1=[1,2]; const arr2=[...arr1,3,4];

// ==================== 6️⃣ Classes & Inheritance ====================
// Pre-ES6: function + prototype
function PersonOld(name){ this.name=name; }
PersonOld.prototype.greet=function(){ console.log(this.name); };
// ES6+
class Person{
  constructor(name){ this.name=name; }
  greet(){ console.log(this.name); }
}
class Student extends Person{
  constructor(name,grade){ super(name); this.grade=grade; }
  show(){ console.log(this.name,this.grade); }
}

// ==================== 7️⃣ Modules ====================
// Pre-ES6: no native, used IIFE/CommonJS/AMD
// ES6+
export const pi=3.14;
import {pi} from './file.js';

// ==================== 8️⃣ Promises & Async ====================
// Pre-ES6: callback hell
doSomething(function(res){ doNext(res,function(n){...}) })
// ES6+
const promise = new Promise((resolve,reject)=>resolve("Done"));
promise.then(res=>console.log(res)).catch(err=>console.error(err));
// Async/Await (ES2017+)
async function fetchData(){ const res=await fetch(url); return res.json(); }

// ==================== 9️⃣ Iterators & For..of ====================
// Pre-ES6: for loop / forEach
// ES6+
for(const val of [1,2,3]) console.log(val);

// ==================== 🔟 Map, Set, WeakMap, WeakSet ====================
// Pre-ES6: object as map, array for set
var mapOld={}; mapOld[1]='one'; // keys converted to string
// ES6+
const map=new Map(); map.set(1,'one');
const set=new Set([1,2,2,3]); // {1,2,3}
const wm=new WeakMap(); const ws=new WeakSet();

// ==================== 1️⃣1️⃣ Symbols ====================
const sym = Symbol("id"); // unique property keys

// ==================== 1️⃣2️⃣ Generators ====================
function* gen(){ yield 1; yield 2; }
const g=gen(); console.log(g.next().value); //1

// ==================== 1️⃣3️⃣ Object Enhancements ====================
const nameVar="Shivam";
const obj={
  nameVar,             // shorthand
  greet(){ console.log("Hi"); }, // method shorthand
  ['age_'+24]:24       // computed property
}
Object.assign({}, {a:1},{b:2}); // {a:1,b:2}

// ==================== 1️⃣4️⃣ Array Methods ====================
[1,2,3].find(x=>x>1);    // 2
[1,2,3].findIndex(x=>x>1);//1
[1,2,3].includes(2);     // true

// ==================== 1️⃣5️⃣ Binary & Octal literals ====================
const bin=0b1010; //10
const oct=0o12;   //10

// ==================== 1️⃣6️⃣ Trailing commas ====================
const arr3=[1,2,3,]; const obj2={a:1,b:2,};

// ==================== 1️⃣7️⃣ Other ES6+ additions ====================
// Exponentiation operator
console.log(2**3); //8
// Object.values / Object.entries
Object.values({a:1,b:2}); // [1,2]
Object.entries({a:1,b:2}); // [['a',1],['b',2]]
// String padding
"5".padStart(3,'0'); // "005"
"5".padEnd(3,'0');   // "500"
