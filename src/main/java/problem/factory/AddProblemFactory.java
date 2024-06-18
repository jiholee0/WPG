package problem.factory;

import problem.template.AddProblem;
import problem.Problem;
import student.Item;
import student.Person;

public class AddProblemFactory extends ProblemFactory {

    private final Person person1;
    private final Person person2;
    private final Item item;
    private final int operand1;
    private final int operand2;

    public AddProblemFactory(Person person1, Person person2, Item item, int operand1, int operand2) {
        this.person1 = person1;
        this.person2 = person2;
        this.item = item;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Problem createProblem() {
        return new AddProblem(person1, person2, item, operand1, operand2);
    }
}
