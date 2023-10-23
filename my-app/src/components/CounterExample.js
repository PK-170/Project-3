import React, { useState } from 'react'


function CounterExample(){

    const [count, setCount] = useState(0)

    function increment(){
        setCount(prevCount => prevCount+1);
    }

    function derement(){
        setCount(prevCount => prevCount-1)
    }
    return(
        <>
             <h1>
                {count}
             </h1>  
             <h1 onClick={increment}>
                <button>Plus</button>
            </h1> 
            <h1 onClick={derement}>
               <button>Minus</button>
            </h1>
        </>
    )
}

export default CounterExample