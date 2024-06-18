package problem.template;

import problem.Problem;
import student.Item;
import student.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DivideProblem implements Problem {
    private final String question;
    private final BigDecimal answer;

    public DivideProblem(Person person, Item item, int operand1, int operand2) {
        this.question =
                String.format("%s(은)는 %s(을)를 %d개 가지고 있습니다. " +
                                "%s(은)는 %d 명의 친구에게 똑같이 나누어 주고 싶습니다. " +
                                "각각 %s(을)를 몇 개씩 가지게 되나요?",
                        person.getName(),
                        item.getName(),
                        operand1,
                        person.getName(),
                        operand2,
                        item.getName()
                );
        // 정답을 소수점 두 자리까지 반올림
        this.answer = new BigDecimal((double) operand1 / operand2)
                .setScale(2, RoundingMode.HALF_UP);    }

    public String getQuestion() {
        return question;
    }
    public boolean isCorrect(String answer) {
        try {
            // 사용자 입력을 소수점 두 자리까지 반올림하여 비교
            BigDecimal userAnswer = new BigDecimal(answer).setScale(2, RoundingMode.HALF_UP);
            return userAnswer.compareTo(this.answer) == 0;
        } catch (NumberFormatException e) {
            return false;  // 사용자 입력이 유효한 숫자가 아닌 경우 false 반환
        }
    }
}
