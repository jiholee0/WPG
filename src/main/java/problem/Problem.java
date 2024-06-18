package problem;

import java.math.BigDecimal;

public interface Problem {
    String getQuestion();
    boolean isCorrect(String answer);
}
