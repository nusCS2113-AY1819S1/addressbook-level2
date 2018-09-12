package seedu.addressbook.common;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;

public class NameComparator implements Comparator<ReadOnlyPerson> {
    public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
        String p1Name = p1.getName().fullName;
        String p2Name = p2.getName().fullName;
        return p1Name.compareTo(p2Name);
    }
}
