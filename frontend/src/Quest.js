import {Component} from "react";
import "./App.css"
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';

class Quest extends Component {

    constructor(props) {
        super(props);
        this.state = {
            questionnaire: {
                id: 0,
                tittle: '',
                questions: [{
                    id: 0,
                    question: '',
                    answers: [{
                        answer: ''
                    }],
                    trueAnswer: ''
                }]
            }
        }

        this.componentDidMount()
    }


    async componentDidMount() {
        const q = await (await fetch(`/questionnaire/${this.props.match.params.id}`)).json()
        this.setState({questionnaire: q})
    }


    render() {
        console.log(this.state.questionnaire)
        const questionList = this.state.questionnaire.questions.map(q => {

            return <ul>{q.question}
                {q.answers.map(an =>{
                    return <Form.Check
                        type="radio"
                        key={an.id}
                        label={an.answer}
                        name="formHorizontalRadios"
                        id={an.id}
                    />
                })}
                {/*{q.answers.map(an => {*/}
                {/*        return <li key={an.answer.toString()}>{an.answer.answer}</li>*/}
                {/*    }*/}
                {/*)}*/}
            </ul>
        })

        return <div className={"App"}>
            <h2>{this.state.questionnaire.title}</h2>
            <br/>
            {questionList}
            {/*<Col sm={10}>*/}
            {/*    <Form.Check*/}
            {/*        type="radio"*/}
            {/*        label="first radio"*/}
            {/*        name="formHorizontalRadios"*/}
            {/*        id="formHorizontalRadios1"*/}
            {/*    />*/}
            {/*    <Form.Check*/}
            {/*        type="radio"*/}
            {/*        label="second radio"*/}
            {/*        name="formHorizontalRadios"*/}
            {/*        id="formHorizontalRadios2"*/}
            {/*    />*/}
            {/*    <Form.Check*/}
            {/*        type="radio"*/}
            {/*        label="third radio"*/}
            {/*        name="formHorizontalRadios"*/}
            {/*        id="formHorizontalRadios3"*/}
            {/*    />*/}
            {/*</Col>*/}
        </div>
    }
}


export default Quest