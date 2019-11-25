 //function that display value 
 function dis(val) 
 { 
     document.getElementById("result").value+=val 
 } 
   
 //function that evaluates the digit and return result 
 function solve() 
 { 
     let x = document.getElementById("result").value 
     //function "eval"  does mathematical operations and returns the value 
     let y = eval(x) 
     document.getElementById("result").value = y 
 } 
   
 //function that clear the display 
 function clr() 
 { 
     document.getElementById("result").value = "" 
 } 