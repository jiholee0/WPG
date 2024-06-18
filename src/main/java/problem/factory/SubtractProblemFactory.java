package problem.factory;

import problem.Problem;
import problem.template.SubtractProblem;
import student.Item;
import student.Person;

public class SubtractProblemFactory extends ProblemFactory {
    private final Person person1;
    private final Person person2;
    private final Item item;
    private final int operand1;
    private final int operand2;

    public SubtractProblemFactory(Person person1, Person person2, Item item, int operand1, int operand2) {
        this.person1 = person1;
        this.person2 = person2;
        this.item = item;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public Problem createProblem() {
        return new SubtractProblem(person1, person2, item, operand1, operand2);
    }
}
