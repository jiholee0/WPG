package problem.template;

import problem.Problem;
import student.Item;
import student.Person;

import java.math.BigDecimal;

public class MultiplyProblem implements Problem {
    private final String question;
    private final BigDecimal answer;

    public MultiplyProblem(Person person, Item item, int operand1, int operand2) {
        this.question =
                String.format("%s(은)는 %d개의 %s(을)를 %d 묶음 가지고 있습니다. " +
                        "%s(은)는 전부 %s(이)가 모두 몇 개입니까?",
                        person.getName(),
                        operand1,
                        item.getName(),
                        operand2,
                        person.getName(),
                        item.getName()
                        );
        this.answer = new BigDecimal(operand1 * operand2);
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
