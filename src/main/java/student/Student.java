package student;

import problem.ProblemGenerator;
import problem.Problem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final InterestedThings interestedThings;
    private final String[] operationType;
    private final int numOfProblems;
    private final int[] range;
    private final List<Problem> workBook;
    private int score;
    private final ProblemGenerator problemGenerator;

    public Student(InterestedThings interestedThings, String[] operationType, int numOfProblems, int[] range){
        this.interestedThings = interestedThings;
        this.operationType = operationType;
        this.numOfProblems = numOfProblems;
        this.range = range;
        this.workBook = new ArrayList<>();
        this.score = 0;
        this.problemGenerator = new ProblemGenerator();
    }

    public void generateProblem(){
        for(String type : operationType){
            workBook.addAll(problemGenerator.generateProblem(
                    type,
                    numOfProblems,
                    interestedThings.getPersonList(),
                    interestedThings.getItemList(),
                    range[0],
                    range[1]));
        }
    }

    public List<Problem> getWorkBook(){
        return this.workBook;
    }

    public int getTotalNumOfProblems(){
        return this.workBook.size();
    }

    public int getScore(){
        return this.score;
    }

    public void addScore(){
        this.score++;
    }
}
