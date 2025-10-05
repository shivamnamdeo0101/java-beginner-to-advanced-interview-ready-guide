
//useMemo Example
//Memoizes expensive calculations.

import React from 'react';

export default function App() {
    const [count,setCount] = React.useState(0);
    function calcFact(num) {
        console.log("calcFact called")
        return num <= 1 ? 1 : num * calcFact(num - 1);
    }

    const fact  = React.useMemo(()=>{
        console.log("from useMemo rendered");
        return calcFact(count);
    }, [count])


    return (
        <>
            <p>Fact: {fact}</p>
            <button onClick={()=>setCount(count+1)}>Increment</button>
        </>
    );
}


import React from 'react';

const ChildComp = React.memo(({ count }) => {
  console.log("Child rendered");
  return <p>Count: {count}</p>;
});


export default function App() {
    const [count,setCount] = React.useState(0);



    return (
        <>
            <p>Count: {count}</p>
            <ChildComp count={count}/>
            <button onClick={()=>setCount(count+1)}>Increment</button>
            <button onClick={()=>setCount(5)}>Increment</button>
            <button onClick={()=>setCount(6)}>Increment</button>

        </>
    );
}


//| Feature          | Class Lifecycle             | useEffect (Functional)                               |
//| ---------------- | --------------------------- | ---------------------------------------------------- |
//| Syntax           | multiple methods            | single hook                                          |
//| Mount            | `componentDidMount`         | `useEffect(() => {}, [])`                            |
//| Update           | `componentDidUpdate`        | `useEffect(() => {}, [deps])`                        |
//| Unmount          | `componentWillUnmount`      | return cleanup function from `useEffect`             |
//| Multiple Effects | Not easy, all in one method | Can use **multiple `useEffect` hooks** independently |

