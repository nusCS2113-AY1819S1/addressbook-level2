package seedu.addressbook.comparators;

import java.util.Comparator;

import seedu.addressbook.data.person.Person;

/**
 * Compare the lexicographical ordering of the name of two persons
 */
public class ComparePerson implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().toString().compareTo(o2.getName().toString());
    }
}
