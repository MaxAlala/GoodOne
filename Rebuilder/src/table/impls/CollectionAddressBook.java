package table.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook {
    public ObservableList<Person> personList = FXCollections.observableArrayList(); // allow you put, change the info into the table(table.fxml)!


    @Override
    public void add(Person person) { personList.add(person); }

    @Override
    public void update(Person person) {


    }

    @Override
    public void delete(Person person) { personList.remove(person);
    }

    public void print(){
        int number = 0;
        System.out.println();
        for(Person person : personList) {
            number++;
            System.out.println(number+" ) fio = "+ person.getName() + "; phone = "+ person.getNumber());

        }

    }

    public void fillTestData() {
        personList.add(new Person("Daria Vseman", "99123958421"));
        personList.add(new Person("Max Vseman", "983123123912"));
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }
}
