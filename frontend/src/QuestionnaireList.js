import {Component} from "react";
import './App.css';
import {Button} from "reactstrap";

class QuestionnaireList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            customer:
                {
                    id: 0,
                    name: '',
                    email: '',
                    role: '',
                    points: 0
                },
            questionnaires: [
                {
                    id: 0,
                    title: '',
                    questions: [
                        {
                            id: 0,
                            question: '',
                            answers: [{
                                answer: ''
                            }],
                            trueAnswer: ''
                        }
                    ]
                }
            ]

        }

        this.componentDidMount()
    }

    async componentDidMount() {
        const user = await (await fetch(`/customer/${this.props.match.params.id}`)).json()
        this.setState({item: user});

        const questionnaires_ = await (await fetch('/questionnaire')).json()
        this.setState({questionnaires: questionnaires_});
        console.log(questionnaires_)
    }

    async addQuestionnaire() {
        if (this.state.customer.role === 'ADMIN')
            return <div className={"App"}>
                добавить анкету
                <Button variant={"dark"}>Пройти</Button>

                {/*Предложить сделать анкету*/}
            </div>

    }

    nextPath(path) {
        this.props.history.push(path);
    }

    render() {
        console.log(this.state.questionnaires)
        const questionnaireList = this.state.questionnaires.map(q => {
            return <tr key={q.id} className={"App"}>
                <td style={{whiteSpace: 'nowrap'}} width="50%">{q.title}</td>
                <td width="10%">Количество вопросов: {q.questions.length}</td>
                <Button onClick={() => this.nextPath(`/questions/${q.id}`)} variant={"dark"}>Пройти</Button>
            </tr>
        })


        return <div className={"App"}>
            Анкеты:
            <br/>
            {questionnaireList}
        </div>

        // this.addQuestionnaire()
    }

}

export default QuestionnaireList