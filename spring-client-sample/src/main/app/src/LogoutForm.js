import React from "react";
import './LogoutForm.css';

export default class LogoutForm extends React.Component {

    constructor(props, context) {
        super(props, context);
    }


    render() {
        return (
            <div id="logout">
                <form action="/logout" method="get">
                    <button type="submit">Log out</button>
                </form>
            </div>
        )
    }
}