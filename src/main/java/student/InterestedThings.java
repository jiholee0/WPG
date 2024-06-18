package student;

import java.util.List;

public class InterestedThings {
    private final List<Person> personList;
    private final List<Item> itemList;

    public InterestedThings(List<Person> personList, List<Item> itemList){
        this.personList = personList;
        this.itemList = itemList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
