package problem;

import problem.factory.ProblemFactoryBuilder;
import student.Item;
import student.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProblemGenerator {
    private final Random random = new Random();

    public List<Problem> generateProblem(
            String type,
            int numOfProblems,
            List<Person> personList,
            List<Item> itemList,
            int rangeStart,
            int rangeEnd){
        List<Problem> problemList = new ArrayList<>();

        for (int i = 0; i < numOfProblems; i++) {
            int num1 = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int num2 = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            Person person1 = personList.get(random.nextInt(personList.size()));
            Person person2 = personList.get(random.nextInt(personList.size()));
            Item item = itemList.get(random.nextInt(itemList.size()));

            problemList.add(new ProblemFactoryBuilder()
                    .setType(type)
                    .setPerson1(person1)
                    .setPerson2(person2)
                    .setItem(item)
                    .setOperand1(num1)
                    .setOperand2(num2)
                    .build().createProblem());
        }
        return problemList;
    }
}
