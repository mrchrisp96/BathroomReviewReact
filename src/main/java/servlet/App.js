var PrintTemplate = require('react-print');
var ReactDOM = require('react-dom');
var React = require('react');

var MyTemplate = React.createClass({
    render() {
        return (
            <PrintTemplate>
                <p>Your custom</p>
                <span>print stuff goes</span>
                <h1>Here</h1>
            </PrintTemplate>
        );
    }
});

ReactDOM.render(<MyTemplate/>, document.getElementById('root'));
