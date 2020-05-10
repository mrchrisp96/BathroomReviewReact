var ReactDOM = require('react-dom');
var React = require('react');

var MyTemplate = React.createClass({
    render() {
        return (
            <p>Your custom</p>
            <h1>Here</h1>
        );
    }
});

ReactDOM.render(<MyTemplate/>, document.getElementById('root'));
