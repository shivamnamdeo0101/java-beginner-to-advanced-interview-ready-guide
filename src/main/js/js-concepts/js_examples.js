// ==========================
// JAVASCRIPT INTERVIEW CHEATSHEET (WH FAMILY CONTEXT)
// Full 23 Topics with WH Context + Examples
// ==========================

(async function JSCheatsheetWH() {
    console.log("=== JAVASCRIPT INTERVIEW CHEATSHEET (WH FAMILY) ===\n");

    // ==========================
    // 1️⃣ VARIABLES & SCOPE
    // ==========================
    /*
    WHAT: var (function scoped), let/const (block scoped)
    WHY: Store/manage data, control access
    WHEN: Always when value required
    HOW: var x=1; let y=2; const z=3;
    RULES: var hoisted; let/const in TDZ(Temporal Dead Zone); const cannot reassign
    PROS: let/const safer, block-scoped
    CONS: var can leak; const objects still mutable
    KEY INSIGHTS: Prefer const > let > var
    */
    {
        var a = 10;
        let b = 20;
        const c = 30;
        console.log("Variables:", a, b, c);
        // Output: Variables: 10 20 30
    }

    // ==========================
    // 2️⃣ HOISTING
    // ==========================
    /*
    WHAT: JS moves declarations to top of scope
    WHY: Allows referencing before declaration
    WHEN: Always, for var and function declarations
    HOW: var/let/const/function declarations
    RULES: var initialized undefined; let/const in TDZ; functions fully hoisted
    PROS: Function hoisting allows calling before definition
    CONS: TDZ errors if accessed early
    KEY INSIGHTS: Understand hoisting to avoid subtle bugs
    */
    {
        var abc;
        console.log("Hoisted abc,",abc); // undefined
        abc = "Shivam"
        console.log("Hoisted assigned abc = Shivam",abc)
        console.log("Hoisted var:", x); // undefined
        var x = 100;
        // console.log(y); // ReferenceError
        let y = 200;
        function foo(){console.log("Function hoisted");}
        foo();
        // Output: Hoisted var: undefined
        // Function hoisted
    }

    // ==========================
    // 3️⃣ FUNCTIONS & CLOSURES
    // ==========================
    /*
    WHAT: Functions are reusable code blocks; Closures retain outer scope access
    WHY: Reusability, encapsulation, state preservation
    WHEN: Anytime reusable logic or private state needed
    HOW: function outer(){ let x; return function inner(){...}}
    RULES: Closures retain references; be mindful of memory
    PROS: Memoization, private state, callbacks
    CONS: Can cause memory leaks if references persist
    KEY INSIGHTS: Closures are powerful for stateful functions
    */
    {
        function outer() {
            let count = 0;
            return function inner() {
                count++;
                console.log("Closure count:", count);
            };
        }
        const counter = outer();
        counter(); // 1
        counter(); // 2
        // Output: Closure count: 1
        // Closure count: 2
    }

    // ==========================
    // 4️⃣ ARROW FUNCTIONS & THIS
    // ==========================
    /*
    WHAT: Short function syntax, no own 'this'
    WHY: Cleaner syntax, lexical this
    WHEN: Callbacks, functional operations
    HOW: const fn = () => {...}
    RULES: Cannot be constructor; no 'arguments' object
    PROS: Avoids bind for callbacks
    CONS: Cannot replace normal function in all contexts
    KEY INSIGHTS: Lexical 'this' simplifies code but requires understanding scope
    */
    {
        const obj = {
            name: "Shivam",
            arrow: () => console.log("Arrow this:", this?.name),
            normal() { console.log("Normal this:", this.name); }
        };
        obj.arrow();  // Arrow this: undefined
        obj.normal(); // Normal this: Shivam
    }

    // ==========================
    // 5️⃣ THIS in different contexts
    // ==========================
    /*
    WHAT: 'this' refers to execution context
    WHY: Determines calling object
    WHEN: Functions, objects, classes
    HOW: function f(){console.log(this)}; obj.method(); new Class()
    RULES: Depends on call site; arrow functions inherit lexical this
    PROS: Dynamically access calling object
    CONS: Confusing in nested/arrow functions
    KEY INSIGHTS: Understand binding rules
    */
    {
        console.log("Global this:", this); // window/global
        function f1(){ console.log("Function this:", this); }
        f1(); // window/global
        const obj = { name:"Obj", f(){ console.log("Obj this:", this.name); } };
        obj.f(); // Obj
        class Person{ constructor(name){this.name=name;} greet(){ console.log("Class this:", this.name); } }
        new Person("Class").greet(); // Class
    }

    // ==========================
    // 6️⃣ ASYNC / AWAIT & PROMISES
    // ==========================
    /*
    WHAT: async functions return Promises; await pauses execution
    WHY: Handle async code in readable way
    WHEN: API calls, DB calls, timers
    HOW: async function fn(){ let data = await promise; }
    RULES: await only inside async; sequential unless Promise.all used
    PROS: Cleaner than .then; easier error handling
    CONS: Sequential awaits block independent ops
    KEY INSIGHTS: Use Promise.all for parallel execution
    */
    {
        const fakeApi = id => new Promise(res => setTimeout(() => res(`Data ${id}`), 500));
        async function fetchData() {
            console.log("Fetching...");
            const data = await fakeApi(1);
            console.log("Received:", data);
        }
        await fetchData();
        // Output: Fetching...
        // Received: Data 1
    }

    // ==========================
    // 7️⃣ EVENT LOOP & CALL STACK
    // ==========================
    /*
    WHAT: JS executes sync first, async via event loop
    WHY: Non-blocking single-thread execution
    WHEN: setTimeout, Promises, async I/O
    HOW: console.log + setTimeout + Promise
    RULES: Microtasks (Promises) run before macrotasks (setTimeout)
    PROS: Efficient async handling
    CONS: Unexpected ordering if misunderstood
    KEY INSIGHTS: Learn microtask vs macrotask order
    */
    {
        console.log("Start Event Loop");
        setTimeout(()=>console.log("setTimeout"), 0);
        Promise.resolve().then(()=>console.log("Promise Microtask"));
        console.log("End Event Loop");
        // Output:
        // Start Event Loop
        // End Event Loop
        // Promise Microtask
        // setTimeout
    }

    // ==========================
    // 8️⃣ IIFE
    // ==========================
    /*
    WHAT: Immediately invoked function expression
    WHY: Create private scope, avoid polluting global
    WHEN: Encapsulate logic or run setup
    HOW: (function(){...})();
    RULES: Needs parentheses to invoke
    PROS: Avoids global variable conflicts
    CONS: Harder to debug if complex
    KEY INSIGHTS: Useful for modular patterns
    */
    {
        (function(){ console.log("IIFE executed"); })();
        // Output: IIFE executed
    }

    // ==========================
    // 9️⃣ ARRAY METHODS & DESTRUCTURING
    // ==========================
    /*
    WHAT: Array operations and destructuring syntax
    WHY: Simplifies data handling
    WHEN: Any array processing
    HOW: arr.map(fn); const [a,b]=arr;
    RULES: Some methods mutate original array (sort, reverse)
    PROS: Concise, readable
    CONS: Overuse may reduce performance
    KEY INSIGHTS: Combine destructuring and spread/rest for clean code
    */
    {
        const arr = [5,3,9,1];
        arr.push(7);
        arr.sort((a,b)=>a-b);
        const [first, second, ...rest] = arr;
        console.log("Array:", first, second, rest);
        // Output: Array: 1 3 [5,7,9]
    }

    // ==========================
    // 10️⃣ OBJECT DESTRUCTURING & SPREAD
    // ==========================
    /*
    WHAT: Extract values; clone/merge objects
    WHY: Simplify access & manipulation
    WHEN: Objects/functions
    HOW: const {a,b}=obj; const clone={...obj}
    RULES: Spread shallow copy; destructuring order matters
    PROS: Concise, readable
    CONS: Nested objects still shared in shallow copy
    KEY INSIGHTS: Simplifies code and parameters
    */
    {
        const obj = {a:1, b:2, c:3};
        const {a, b, ...others} = obj;
        console.log(a, b, others); // 1 2 {c:3}
        const clone = {...obj, d:4};
        console.log(clone); // {a:1,b:2,c:3,d:4}
    }

    // ==========================
    // 11️⃣ PROTOTYPE & INHERITANCE
    // ==========================
    /*
    WHAT: Objects inherit via prototype chain
    WHY: Share methods efficiently
    WHEN: OOP or class-less inheritance
    HOW: function C(){...}; C.prototype.method=fn;
    RULES: Prototype methods shared across instances
    PROS: Memory-efficient
    CONS: Dynamic property assignment can confuse
    KEY INSIGHTS: Understand prototype chain
    */
    {
        function Person(name){ this.name=name; }
        Person.prototype.sayHi = function(){ console.log("Hi", this.name); }
        const p1 = new Person("Shivam");
        p1.sayHi();
        // Output: Hi Shivam
    }

    // ==========================
    // 12️⃣ CLASSES & INHERITANCE (ES6)
    // ==========================
    /*
    WHAT: Syntactic sugar for constructor functions; supports extends
    WHY: Easier OOP in JS
    WHEN: Objects with methods and inheritance
    HOW: class Animal{...}; class Dog extends Animal{...}
    RULES: Methods on prototype; super() in derived class
    PROS: Cleaner, readable
    CONS: Still prototypal under the hood
    KEY INSIGHTS: Classes make inheritance familiar
    */
    {
        class Animal{ constructor(name){this.name=name;} speak(){ console.log(this.name+" makes sound"); } }
        class Dog extends Animal{ speak(){ console.log(this.name+" barks"); } }
        new Dog("Rex").speak();
        // Output: Rex barks
    }

    // ==========================
    // 13️⃣ DEBOUNCE
    // ==========================
    /*
    WHAT: Limits function fire rate; triggers after inactivity
    WHY: Optimize performance for frequent events
    WHEN: Input, scroll, resize
    HOW: debounce(fn, delay)
    RULES: Timer resets each call until delay passes
    PROS: Reduces function calls
    CONS: Delayed execution
    KEY INSIGHTS: Use for input/search optimization
    */
    {
        function debounce(fn, delay){
            let timer;
            return function(...args){ clearTimeout(timer); timer = setTimeout(()=>fn.apply(this,args), delay); }
        }
        const logDebounce = debounce(msg => console.log("Debounce:", msg), 300);
        logDebounce("Hello");
        logDebounce("World");
        // Output: Debounce: World
    }

    // ==========================
    // 14️⃣ THROTTLE
    // ==========================
    /*
    WHAT: Ensures function fires at most once per interval
    WHY: Control rate of high-frequency events
    WHEN: Scroll, resize, mousemove
    HOW: throttle(fn, limit)
    RULES: Fires once per interval; ignores extra calls
    PROS: Predictable rate, reduces load
    CONS: May skip calls
    KEY INSIGHTS: Use when consistent execution needed
    */
    {
        function throttle(fn, limit){
            let lastCall = 0;
            return function(...args){
                const now = Date.now();
                if(now - lastCall >= limit){
                    lastCall = now;
                    fn.apply(this,args);
                }
            };
        }
        const logThrottle = throttle(msg => console.log("Throttle:", msg), 500);
        logThrottle("A"); logThrottle("B"); // Only "A" logs
    }

    // ==========================
    // 15️⃣ SHALLOW VS DEEP COPY
    // ==========================
    /*
    WHAT: Shallow copies top-level; deep copies nested
    WHY: Avoid unintended mutations
    WHEN: Copy objects/arrays
    HOW: {...obj} shallow; JSON.parse(JSON.stringify(obj)) deep
    RULES: Shallow=top only; deep loses functions/undefined
    PROS: Deep prevents shared reference bugs
    CONS: Deep expensive; functions lost
    KEY INSIGHTS: Know when to use each
    */
    {
        const obj = {a:1, b:{c:2}};
        const shallow = {...obj};
        const deep = JSON.parse(JSON.stringify(obj));
        obj.b.c = 99;
        console.log("Shallow:", shallow.b.c); // 99
        console.log("Deep:", deep.b.c);       // 2
    }

    // ==========================
    // 16️⃣ CURRYING
    // ==========================
    /*
    WHAT: Transform function to take args one at a time
    WHY: Partial application, functional programming
    WHEN: Reusable configs, modular code
    HOW: const fn = a => b => c => a+b+c
    RULES: Each returns next until all args supplied
    PROS: Flexible, reusable
    CONS: Harder to read
    KEY INSIGHTS: Useful for modular functions
    */
    {
        const add = a => b => c => a+b+c;
        console.log("Curried:", add(1)(2)(3)); // 6
    }

    // ==========================
    // 17️⃣ MODULE SYSTEM
    // ==========================
    /*
    WHAT: ES6 import/export system
    WHY: Organize, reuse code
    WHEN: Large projects
    HOW: export function add(){}; import {add} from './file.js'
    RULES: Module files; imports top-level
    PROS: Encapsulation, maintainability
    CONS: Older browsers may need transpiling
    KEY INSIGHTS: Prefer modules over global scripts
    */
    // Example cannot run inline in single file, concept only

    // ==========================
    // 18️⃣ EVENT DELEGATION
    // ==========================
    /*
    WHAT: Attach listener to parent for dynamic children
    WHY: Performance & dynamic elements
    WHEN: Lists, tables, repeated elements
    HOW: parent.addEventListener('click', e=>{if(e.target.tagName==='LI') ...})
    RULES: Event bubbles; must check target
    PROS: Fewer listeners; works for dynamic children
    CONS: Careful target checking required
    KEY INSIGHTS: Essential for large DOM
    */
    // Example requires DOM; concept only

    // ==========================
    // 19️⃣ TYPE COERCION
    // ==========================
    /*
    WHAT: JS converts types automatically
    WHY: Flexible but confusing
    WHEN: Arithmetic, comparisons, string concatenation
    HOW: '5'-1 => 4; 10+'5' => "105"
    RULES: == triggers coercion; === strict
    PROS: Convenient
    CONS: Can cause bugs
    KEY INSIGHTS: Prefer === to avoid surprises
    */
    {
        console.log("Coerce 5-'1':", '5'-'1'); // 4
        console.log("Coerce 10+'5':", 10+'5'); // "105"
    }

    // ==========================
    // 20️⃣ OPTIONAL CHAINING & NULLISH COALESCING
    // ==========================
    /*
    WHAT: Safe property access & default values
    WHY: Avoid runtime errors on undefined/null
    WHEN: Nested objects, optional params
    HOW: obj?.prop?.sub; val ?? default
    RULES: Stops at first null/undefined
    PROS: Prevents TypeErrors, concise
    CONS: Only null/undefined checks
    KEY INSIGHTS: Essential for safe traversal
    */
    {
        const user = {name:"Shivam"};
        console.log("Optional chain:", user?.address?.street ?? "No street"); // No street
    }

    // ==========================
    // 21️⃣ TEMPLATE LITERALS
    // ==========================
    /*
    WHAT: String interpolation with backticks
    WHY: Embed variables/expressions
    WHEN: Multi-line or dynamic strings
    HOW: `Name: ${name}`
    RULES: Backticks required
    PROS: Cleaner, readable
    CONS: Slight overhead large templates
    KEY INSIGHTS: Use over concatenation
    */
    {
        const name="Shivam", age=25;
        console.log(`Name: ${name}, Age: ${age}`); // Name: Shivam, Age: 25
    }

    // ==========================
    // 22️⃣ SET & MAP
    // ==========================
    /*
    WHAT: ES6 collections; Set unique; Map key-value
    WHY: Efficient data structures
    WHEN: Remove duplicates, map data
    HOW: new Set([...]); new Map([[key,val],[...]])
    RULES: Set unique; Map preserves insertion order
    PROS: Fast lookups, built-in methods
    CONS: Slightly more memory than arrays/objects
    KEY INSIGHTS: Prefer Sets/Maps for collections
    */
    {
        const s = new Set([1,2,2,3]);
        console.log("Set:", [...s]); // [1,2,3]
        const m = new Map([["a",1],["b",2]]);
        console.log("Map get b:", m.get("b")); // 2
    }

    // ==========================
    // 23️⃣ SYMBOL & GENERATORS
    // ==========================
    /*
    WHAT: Symbol = unique id; Generators = pause/resume functions
    WHY: Avoid name collisions; lazy sequences
    WHEN: Private keys; iterative sequences
    HOW: const sym = Symbol(); function* gen(){yield 1;}
    RULES: Symbol unique; generators use yield
    PROS: Unique keys, memory-efficient iteration
    CONS: Less intuitive initially
    KEY INSIGHTS: Symbols for hidden props; generators for controlled iteration
    */
    {
        const sym = Symbol("id");
        const obj = {[sym]:123};
        console.log("Symbol property:", obj[sym]); // 123

        function* gen(){ yield 1; yield 2; yield 3; }
        const g = gen();
        console.log("Generator:", g.next().value); // 1
        console.log("Generator:", g.next().value); // 2
    }
    // ==========================
    // 24 PROMISES & PROMISE.ALL
    // ==========================
    /*
    WHAT: Promises represent asynchronous operations (pending → fulfilled/rejected)
    WHY: Handle async code without callback hell
    WHEN: Any async operation (API call, timeout, file read)
    HOW:
       - new Promise((resolve,reject)=>{...})
       - promise.then(...).catch(...)
    RULES:
       - Always handle rejection (catch)
       - `Promise.all` waits for all promises, fails fast if any rejects
    PROS: Cleaner async code, chaining possible
    CONS: `Promise.all` fails if any promise rejects; need try/catch with async/await
    KEY INSIGHTS: Use async/await with Promise.all for readability
    */

    // Example: Single Promise
    const promise1 = new Promise((resolve, reject) => {
        setTimeout(() => resolve("Result 1"), 1000);
    });

    promise1.then(result => console.log("Promise1:", result))
            .catch(err => console.error(err));
    // Output after 1s: Promise1: Result 1

    // Example: Multiple Promises with Promise.all
    const promise2 = new Promise(resolve => setTimeout(() => resolve("Result 2"), 2000));
    const promise3 = new Promise(resolve => setTimeout(() => resolve("Result 3"), 1500));

    Promise.all([promise1, promise2, promise3])
        .then(results => console.log("Promise.all results:", results))
        .catch(err => console.error("Promise.all error:", err));
    // Output after ~2s: Promise.all results: ["Result 1", "Result 2", "Result 3"]

})();
