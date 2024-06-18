package problem.template;

import problem.Problem;
import student.Item;
import student.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AddProblem implements Problem {
    private final String question;
    private final BigDecimal answer;

    public AddProblem(Person person1, Person person2, Item item, int operand1, int operand2) {
        this.question =
                String.format("%s(은)는 %s(을)를 %d개 가지고 있습니다. " +
                        "%s(은)는 %s(을)를 %d개 가지고 있습니다. " +
                        "그들이 가지고 있는 %s(은)는 모두 몇 개입니까?",
                        person1.getName(),
                        item.getName(),
                        operand1,
                        person2.getName(),
                        item.getName(),
                        operand2,
                        item.getName()
                        );
        this.answer = new BigDecimal(operand1 + operand2);
    }

    public String getQuestion() {
        return question;
    }
    public boolean isCorrect(String answer) {
        try {
            return new BigDecimal(answer).equals(this.answer);
        } catch (NumberFormatException e) {
            return false;  // 사용자 입력이 유효한 숫자가 아닌 경우 false 반환
        }
    }
}
