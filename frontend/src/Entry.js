import React, {Component} from "react";
import './App.css';

function LoginForm(props) {
    const [email, setEmail] = React.useState('');
    const [name, setName] = React.useState('');

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        const customer = {email: email, role: 'USER', name: name}

        const en = new Entry(props)
        en.push(customer)
    };

    return (
        <form onSubmit={handleSubmit} className={"App"}>
            <div>
                <label htmlFor='name'>Name </label>
                <br/>
                <input type='name' id='nme' value={name} onChange={(e) => setName(e.target.value)}/>
            </div>
            <div>
                <label htmlFor='email'>Email </label>
                <br/>
                <input type='email' id='email' value={email} onChange={(e) => setEmail(e.target.value)}/>
            </div>
            <input type="submit"/>
        </form>
    );
}

class Entry extends Component {
    constructor(props) {
        super(props);
    }

    async push(customer) {
        console.log(customer)
        const buff = await fetch('/customer', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(customer),
        }).then((response) => {
            return response
                .json()
                .then((data) => {
                    return data
                })
                .catch((err) => {
                    console.log(err)
                })
        })

        console.log(buff)
        this.props.history.push('/customer/' + buff.id)
    }
}

export default LoginForm