import React from "react";
import './TextReplacementForm.css';

export default class TextReplacementForm extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            replacedText: "",
            textReplacement: {
                text: "",
                toReplace: "",
                fromReplace: ""
            }
        }
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        fetch("http://localhost:8080/api/v1/text/grpc-replace", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Content-Encoding': 'UTF-8'
            },
            body: JSON.stringify(this.state.textReplacement)
        })
            .then(res => res.json())
            .then(
                (res) => {
                    this.setState({replacedText: res.replacedText})
                },
                (error) => {
                    console.log(error);
                });
    }

    handleChange(e) {
        console.log(e)
        let id = e.target.id;
        let textReplacement = {...this.state.textReplacement}
        switch (id) {
            case "text":
                textReplacement.text = e.target.value
                break;
            case "fromReplace":
                textReplacement.fromReplace = e.target.value
                break;
            case "toReplace":
                textReplacement.toReplace = e.target.value
                break;
        }
        this.setState({textReplacement})
    }

    render() {
        return (
            <div>
                <h1>Text Replacement App</h1>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Your text
                            <textarea id="text" value={this.state.textReplacement.text} onChange={this.handleChange}/>
                        </label>
                    </div>
                    <div>
                        <label>Text replace from
                            <textarea id="fromReplace" value={this.state.textReplacement.fromReplace}
                                      onChange={this.handleChange}/>
                        </label>
                    </div>
                    <div>
                        <label>Text replace to
                            <textarea id="toReplace" value={this.state.textReplacement.toReplace}
                                      onChange={this.handleChange}/>
                        </label>
                    </div>
                    <input type="submit" value="Send"/>
                </form>
                <br/>
                <label>Result
                    <textarea id="replacedText" value={this.state.replacedText}/>
                </label>
            </div>
        )
    }
}