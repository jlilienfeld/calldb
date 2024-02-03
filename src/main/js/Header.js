import React from 'react';

export class Header extends React.Component {

    constructor(props) {
        super(props);

        this.onCurrentPersonChanged = this.onCurrentPersonChanged.bind(this);
    }

    onCurrentPersonChanged(event) {
        const person = this.props.persons.find(person => person.id === parseInt(event.target.value));

        this.props.onCurrentPersonChanged(person);
    }

    render() {
        const persons = this.props.persons;
        const currentPersonId = this.props.currentPersonId;

        return (
            <header className="sticky top-0 bg-slate-700 border-b border-slate-200 z-30">
                <div className="px-4 sm:px-6 lg:px-8">
                    <div className="flex items-center justify-between h-16 -mb-px">

                        {/* Header: Left side */}
                        <div className="flex items-center">
                            <label className="block text-sm font-medium mb-1 mr-5" htmlFor="name">Show call for this person: </label>

                            <select onChange={this.onCurrentPersonChanged} id="selected-person" className="form-select bg-slate-400">
                                {persons.map((person => {
                                    const personFullName = person.fullName;

                                    return (
                                        <option value={person.id} key={person.id}>{personFullName}</option>);
                                }))
                                }
                            </select>
                        </div>

                        {/* Header: Right side */}
                        <div className="flex items-center space-x-3">
                            <div>
                                Place Holder 1
                            </div>
                            <div>
                                Place Holder 2
                            </div>
                            {/*  Divider */}
                            <hr className="w-px h-6 bg-slate-200 mx-3"/>
                            <div>
                                Place Holder 3
                            </div>
                            <div>
                                Place Holder 4
                            </div>
                            {/*  Divider */}
                            <hr className="w-px h-6 bg-slate-200 mx-3"/>
                            <div>
                                Place Holder 5
                            </div>
                            <div>
                                Place Holder 6
                            </div>
                        </div>

                    </div>
                </div>
            </header>
        );
    }
}
