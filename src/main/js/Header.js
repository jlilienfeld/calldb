import React from 'react';
import Combobox from "react-widgets/Combobox";

export class Header extends React.Component {

    constructor(props) {
        super(props);

        this.onCurrentPersonChanged = this.onCurrentPersonChanged.bind(this);
        this.onPersonComboboxChanged = this.onPersonComboboxChanged.bind(this);
    }

    onCurrentPersonChanged(event) {
        const person = this.props.persons.find(person => person.id === parseInt(event.target.value));

        this.props.onCurrentPersonChanged(person);
    }

    onPersonComboboxChanged(event) {
        if (typeof event === 'string' || event instanceof String) {
            this.props.onCurrentPersonSearchChanged(event);
        } else {
            this.props.onCurrentPersonChanged(event);
        }
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
                            <label className="block text-slate-100 text-lg mb-1 mr-5" htmlFor="name">Show call for this person: </label>

                            <div>
                                <Combobox
                                    onChange={this.onPersonComboboxChanged}
                                    dataKey='id'
                                    textField='fullName'
                                    data={persons}
                                />
                            </div>
                        </div>

                        {/* Header: Right side */}
                        <div className="flex items-center space-x-3">
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
