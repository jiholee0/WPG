package problem.factory;

import student.Item;
import student.Person;

public class ProblemFactoryBuilder {
    private Person person1;
    private Person person2;
    private Item item;
    private int operand1;
    private int operand2;
    private String type;

    public ProblemFactoryBuilder setPerson1(Person person) {
        this.person1 = person;
        return this;
    }

    public ProblemFactoryBuilder setPerson2(Person person) {
        this.person2 = person;
        return this;
    }

    public ProblemFactoryBuilder setItem(Item item) {
        this.item = item;
        return this;
    }

    public ProblemFactoryBuilder setOperand1(int operand1) {
        this.operand1 = operand1;
        return this;
    }

    public ProblemFactoryBuilder setOperand2(int operand2) {
        this.operand2 = operand2;
        return this;
    }

    public ProblemFactoryBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public ProblemFactory build() {
        return switch (type) {
            case "+" -> new AddProblemFactory(person1, person2, item, operand1, operand2);
            case "-" -> new SubtractProblemFactory(person1, person2, item, operand1, operand2);
            case "*" -> new MultiplyProblemFactory(person1, item, operand1, operand2);
            case "/" -> new DivideProblemFactory(person1, item, operand1, operand2);
            default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        };
    }
}
