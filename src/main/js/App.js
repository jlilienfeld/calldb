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
            calls: [],
            currentPerson: null};

        this.onCurrentPersonChanged = this.onCurrentPersonChanged.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/persons'}).then(response => {
            this.setState({persons: response.entity._embedded.persons});
        });
    }

    onCurrentPersonChanged(person) {
        let newState = this.state;
        newState.currentPerson = person;
        this.state.calls = person.calls.map(call => call._embedded.call);
        this.setState(newState);
        console.log("New person selected: " + person)
    }

    render() {
        const currentPersonId = this.state.currentPerson ? this.state.currentPerson.id : null;
        return (
            <div className="flex h-screen overflow-hidden">
                <div className="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
                    <Header persons={this.state.persons}
                            currentPersonId={currentPersonId}
                            currentView={this.state.currentView}
                            onCurrentPersonChanged={this.onCurrentPersonChanged}/>
                    <main>
                        <div className="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">
                            <div>
                                Calls that <b>{this.state.currentPerson ? this.state.currentPerson.fullName: ""}</b> were in.
                            </div>

                            <div
                                className="mt-4 col-span-full bg-slate-500 shadow-lg rounded-sm border border-slate-200">

                                <table className="table-auto w-full">
                                    <thead className="text-xs uppercase text-slate-400 bg-slate-600 rounded-sm">
                                    <tr>
                                        <th className="p-2 whitespace-nowrap">
                                            <div className="font-semibold text-left">Time of the call</div>
                                        </th>
                                        <th>
                                            <div className="font-semibold text-left">Participants</div>
                                        </th>
                                        <th>
                                            Location
                                        </th>
                                        <th>
                                            Type
                                        </th>
                                        <th>
                                            <div className="font-semibold text-left">Duration (seconds)</div>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody className="text-sm divide-y divide-slate-100">
                                    {
                                        this.state.calls.map(call => {
                                            return (
                                                <tr key={call.id}>
                                                    <td>{call.startTime} to {call.endTime}</td>
                                                    <td>{call.persons.reduce((acc, person) =>
                                                        acc + "  " + person.personName + "("+ person.personRole +")", "")}</td>
                                                    <td>{call.cityName}</td>
                                                    <td>{call.callMethodName}</td>
                                                    <td>{call.duration}</td>
                                                </tr>
                                            );
                                        })
                                    }
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </main>
                </div>
            </div>
        )
    }
}


const root = ReactDOM.createRoot(document.getElementById('react'));
root.render(
    <React.StrictMode>
        <App/>
    </React.StrictMode>
);
