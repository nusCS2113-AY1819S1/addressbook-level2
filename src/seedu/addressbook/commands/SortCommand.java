package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;
import java.lang.*;


//sort the name list based on alphabetical order
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    NameComparator nameComp = new NameComparator();

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPerson = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> sortedPerson = new ArrayList<>();
        sortedPerson.addAll(allPerson);

        sortedPerson.sort(nameComp);

        return new CommandResult(getMessageForPersonListShownSummary(allPerson), sortedPerson);
    }
}

class NameComparator implements Comparator<ReadOnlyPerson> {

    public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
        return p1.getName().fullName.compareTo(p2.getName().fullName);
    }

    public boolean equals(Object obj) {
        return this == obj;
    }
}