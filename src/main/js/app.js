const React = require('react');
const ReactDOM = require('react-dom/client');
const client = require('./client');

import './app.css';

import {Header} from './Header'

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            persons: [],
            currentPersonId: null};

        this.onCurrentPersonChanged = this.onCurrentPersonChanged.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/persons'}).then(response => {
            this.setState({persons: response.entity._embedded.persons});
        });
    }

    onCurrentPersonChanged(person) {
        let newState = this.state;
        newState.currentPersonId = person.id;
        this.setState(newState);
    }

    render() {
        return (
            <div className="flex h-screen overflow-hidden">
                <div className="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
                    <Header persons={this.state.persons}
                            currentPersonId={this.state.currentPersonId}
                            currentView={this.state.currentView}
                            onCurrentPersonChanged={this.onCurrentPersonChanged}/>

                </div>
            </div>
        )
    }
}


const root = ReactDOM.createRoot(document.getElementById('react'));
root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);