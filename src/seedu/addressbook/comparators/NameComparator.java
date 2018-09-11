package seedu.addressbook.comparators;

import seedu.addressbook.data.person.Person;

import java.util.Comparator;

/**
 * Alphabetical comparator for Names
 */
public class NameComparator implements Comparator<Person> {
    public int compare (Person p, Person p2){
        return  p.getName().fullName.compareToIgnoreCase(p2.getName().fullName);
    }
}
