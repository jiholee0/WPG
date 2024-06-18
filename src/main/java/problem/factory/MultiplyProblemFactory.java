package problem.factory;

import problem.template.MultiplyProblem;
import problem.Problem;
import student.Item;
import student.Person;

public class MultiplyProblemFactory extends ProblemFactory {
    private final Person person;
    private final Item item;
    private final int operand1;
    private final int operand2;

    public MultiplyProblemFactory(Person person, Item item, int operand1, int operand2) {
        this.person = person;
        this.item = item;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public Problem createProblem() {
        return new MultiplyProblem(person, item, operand1, operand2);
    }
}
