const React = require('react');
const ReactDOM = require('react-dom/client');
const client = require('./client');

import './app.css';

import {Header} from './Header'
import Combobox from "react-widgets/Combobox";

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            persons: [],
            calls: [],
            currentPerson: null};

        this.onCurrentPersonChanged = this.onCurrentPersonChanged.bind(this);
        this.onCurrentPersonSearchChanged = this.onCurrentPersonSearchChanged.bind(this);
        this.onPersonClicked = this.onPersonClicked.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/persons'}).then(response => {
            this.setState({persons: response.entity._embedded.persons});
        });
    }

    onPersonClicked(person) {
        // When a person is clicked, all we got is only a projection, a subset of a person.  We need to make a query to
        // fetch the full view of a person.
        client({method: 'GET', path: '/api/persons/' + person.id}).then(response => {
            let newState = this.state;
            newState.persons = [response.entity];
            newState.currentPerson = person;
            newState.calls = response.entity.calls.map(call => call._embedded.call);
            this.setState(newState);
            console.log("New person selected: " + person)
        });
    }

    onCurrentPersonChanged(person) {
        let newState = this.state;
        newState.currentPerson = person;
        this.state.calls = person.calls.map(call => call._embedded.call);
        this.setState(newState);
        console.log("New person selected: " + person)
    }

    onCurrentPersonSearchChanged(searchName) {
        client({method: 'GET', path: '/api/persons/search/findByFullNameContaining?fullName='+searchName}).then(response => {
            this.setState({persons: response.entity._embedded.persons});
        });
    }

    render() {
        const currentPersonId = this.state.currentPerson ? this.state.currentPerson.id : null;
        return (
            <div className="flex h-screen overflow-hidden">
                <div className="relative flex flex-col flex-1 overflow-y-auto overflow-x-hidden">
                    <Header persons={this.state.persons}
                            currentPersonId={currentPersonId}
                            currentView={this.state.currentView}
                            onCurrentPersonChanged={this.onCurrentPersonChanged}
                            onCurrentPersonSearchChanged={this.onCurrentPersonSearchChanged}/>
                    <main>
                        <div className="px-4 sm:px-6 lg:px-8 py-8 w-full max-w-9xl mx-auto">
                            <div>
                                Calls that <b>{this.state.currentPerson ? this.state.currentPerson.fullName: ""}</b> were in.
                            </div>

                            <div
                                className="mt-4 col-span-full bg-slate-500 shadow-lg rounded-sm border border-slate-200">

                                <table className="table-auto w-full">
                                    <thead className="text-lg uppercase text-slate-400 bg-slate-600 rounded-sm">
                                    <tr>
                                        <th className="p-2 whitespace-nowrap">
                                            <div className="font-semibold text-left">Time of the call</div>
                                        </th>
                                        <th className="p-2 whitespace-nowrap">
                                            <div className="font-semibold text-left">Participants</div>
                                        </th>
                                        <th className="p-2 whitespace-nowrap">
                                            <div className="font-semibold text-left">Location</div>
                                        </th>
                                        <th className="p-2 whitespace-nowrap">
                                            <div className="font-semibold text-left">Type</div>
                                        </th>
                                        <th className="p-2 whitespace-nowrap">
                                            <div className="font-semibold text-left">Duration (seconds)</div>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody className="text-lg text-slate-900 divide-y divide-slate-100">
                                    {
                                        this.state.calls.map(call => {
                                            return (
                                                <tr key={call.id}>
                                                    <td className="p-2 whitespace-nowrap">
                                                            {call.startTime}<br />to<br/> {call.endTime}
                                                    </td>
                                                    <td className="p-2 whitespace-nowrap">
                                                        <ul className="list-disc">
                                                            {
                                                                call.persons.map(
                                                                    person =>
                                                                        (
                                                                            <li
                                                                                key={person.id}
                                                                                onClick={() => this.onPersonClicked(person)}
                                                                                className="font-semibold cursor-pointer">
                                                                                {person.personName + "(" + person.personRole + ")"}
                                                                            </li>
                                                                        )
                                                                )
                                                            }
                                                        </ul>
                                                    </td>
                                                    <td className="p-2 whitespace-nowrap">
                                                            {call.cityName}
                                                    </td>
                                                    <td className="p-2 whitespace-nowrap">
                                                            {call.callMethodName}
                                                    </td>
                                                    <td className="p-2 whitespace-nowrap">
                                                            {call.duration}
                                                    </td>
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
