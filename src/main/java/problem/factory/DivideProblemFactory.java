package problem.factory;

import problem.template.DivideProblem;
import problem.Problem;
import student.Item;
import student.Person;

public class DivideProblemFactory extends ProblemFactory {
    private final Person person;
    private final Item item;
    private final int operand1;
    private final int operand2;

    public DivideProblemFactory(Person person, Item item, int operand1, int operand2) {
        this.person = person;
        this.item = item;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public Problem createProblem() {
        return new DivideProblem(person, item, operand1, operand2);
    }
}
