import React from "react";
import ReactDOM from "react-dom";
import "./styles.css";

function App() {
  return (
    <div className="App">
      <h1>Hello CodeSandbox</h1>
      <h2>Start editing to see some magic happen!</h2>
    </div>
  );
}
                
const element = <h1>Hello, world</h1>;
ReactDOM.render(element, document.getElementById('root'));
