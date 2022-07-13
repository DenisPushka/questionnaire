import {Component} from "react";
import './App.css';

class CustomerList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            customers: [
                {
                    id: 0,
                    name: '',
                    email: '',
                    role: '',
                    points: 0
                }
            ]
        }
    }

    async componentDidMount() {
        const customers = await (await fetch(`/customer`)).json();
        this.setState({customers: customers});
    }

    render() {
        const customerList = this.state.map(customer => {
                return <tr key={customer.id}>
                    <td style={{whiteSpace: 'nowrap'}} width="40%">{customer.name}</td>
                    <td width="30%">Почта = {customer.email}</td>
                    <td width="60%">Очки = {customer.points}</td>
                </tr>
            }
        )

        return <div className={"App"}>
            {customerList}
        </div>
    }
}

export default CustomerList