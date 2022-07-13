import './App.css';
import {Component} from "react";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";

import Entry from "./Entry"
import CustomerList from "./CustomerList"
import Questions from "./Quest"
import QuestionnaireList from "./QuestionnaireList"

class App extends Component{
    render() {
        return (
            <Router>
                <Switch>
                    <Route path={'/'} exact={true} component={Entry}/>
                    <Route path={'/customer'} exact={true} component={CustomerList}/>
                    <Route path={'/customer/:id'} component={QuestionnaireList}/>
                    <Route path={'/questionnaire'} component={QuestionnaireList}/>
                    <Route path={'/questions/:id'} component={Questions}/>
                </Switch>
            </Router>
        )
    }
}

export default App;
