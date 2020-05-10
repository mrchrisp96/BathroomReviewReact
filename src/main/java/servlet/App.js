import React, { useState, useEffect } from 'react';

const App = () => {
  const [ spinner, setSpinner ] = useState(true);

  // It will be executed before rendering

  useEffect(() => {
    setTimeout(() => setSpinner(false), 1000)
  }, []);

  // [] means like componentDidMount

  return !spinner && <div>Your content</div>;
};

export default App;
