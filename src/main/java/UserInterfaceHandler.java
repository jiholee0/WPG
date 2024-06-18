import student.InterestedThings;
import student.Item;
import student.Person;
import student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * CLI 기반의 Input Handler
 */
public class UserInterfaceHandler {
    private static UserInterfaceHandler instance;
    private final Scanner scanner;

    private UserInterfaceHandler(){
        this.scanner = new Scanner(System.in);
    }

    public static UserInterfaceHandler getInstance(){
        if(instance == null){
            instance = new UserInterfaceHandler();
        }
        return instance;
    }
    public InterestedThings getInterestedThings(){
        List<Person> personList = getInterestedPeople();
        List<Item> itemList = getInterestedItems();
        return new InterestedThings(personList, itemList);
    }

    /**
     * 연산자를 입력 받는 메서드
     */
    public String[] getOperationType(){
        System.out.print("- 문제를 생성할 연산의 종류를 공백을 기준으로 입력하세요(+, -, *, /) : ");
        return scanner.nextLine().split(" ");
    }

    /**
     * 생성할 문제 수를 입력 받는 메서드
     */
    public int getNumOfProblems(){
        System.out.print("- 생성할 문제 수를 입력하세요 : ");
        while (!scanner.hasNextInt()){
            scanner.next();
            System.out.println("올바르지 않은 입력값입니다. 다시 입력하세요 : ");
        }
        return scanner.nextInt();
    }

    /**
     * 피연산자의 범위를 입력 받는 메서드
     */
    public int[] getOperandRange(){
        System.out.print("- 피연산자의 범위를 공백을 기준으로 입력하세요 : ");
        int[] range = new int[2];
        for (int i = 0; i < 2; i++) {
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.print("- 올바르지 않은 입력값입니다. 다시 입력하세요 : ");
            }
            range[i] = scanner.nextInt();
        }
        return range;
    }

    /**
     * 사람들의 이름을 입력 받는 메서드
     */
    private List<Person> getInterestedPeople(){
        System.out.print("- 자녀에게 중요한 사람들의 이름을 공백을 기준으로 입력하세요 : ");
        String[] array = scanner.nextLine().split(" ");
        return Arrays.stream(array)
                .map(Person::new)
                .collect(Collectors.toList());
    }

    /**
     * 항목들의 이름을 입력 받는 메서드
     */
    private List<Item> getInterestedItems(){
        System.out.print("- 자녀가 관심을 갖고 있는 항목들의 이름을 공백을 기준으로 입력하세요 : ");
        String[] array = scanner.nextLine().split(" ");
        return Arrays.stream(array)
                .map(Item::new)
                .collect(Collectors.toList());
    }

    /**
     * 문제의 정답을 입력 받는 메서드
     */
    public String getAnswer(String question, int idx){
        System.out.println("\n---------------");
        System.out.print(idx + ". ");
        System.out.print(question + "\n 답 :");
        return scanner.next();
    }

    /**
     * 학생의 점수를 출력하는 메서드
     */
    public void printScore(Student student){
        System.out.println("*****\n\n" + student.getScore() +"점/" + student.getTotalNumOfProblems() + "문제\n\n*****");
    }

    public void close() {
        scanner.close();
    }
}
