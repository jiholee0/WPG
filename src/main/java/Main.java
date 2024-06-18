import problem.Problem;
import student.InterestedThings;
import student.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterfaceHandler uiHandler = UserInterfaceHandler.getInstance();

        try {
            InterestedThings interestedThings = uiHandler.getInterestedThings();
            String[] operationType = uiHandler.getOperationType();
            int numOfProblems = uiHandler.getNumOfProblems();
            int[] operandRange = uiHandler.getOperandRange();

            Student student = new Student(interestedThings, operationType, numOfProblems, operandRange);
            student.generateProblem(); // 문제를 생성한다.

            List<Problem> workBook = student.getWorkBook(); // 워크북에 있는 문제를 푼다.
            int idx = 1;
            for(Problem problem : workBook){
                String answer = uiHandler.getAnswer(problem.getQuestion(), idx++);
                if(problem.isCorrect(answer)) {
                    student.addScore();
                }
            }

            uiHandler.printScore(student); // 점수를 출력한다.

        } finally {
            uiHandler.close();
        }
    }
}
