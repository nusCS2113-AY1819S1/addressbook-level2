package seedu.addressbook.commands;

import seedu.addressbook.data.person.*;

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
        List<ReadOnlyPerson> allPerson = new ArrayList<>();
        allPerson.addAll(addressBook.getAllPersons().immutableListView());
        allPerson.sort(nameComp);

        return new CommandResult(getMessageForPersonListShownSummary(allPerson), allPerson);
    }
}

class NameComparator implements Comparator<ReadOnlyPerson> {

    public int compare(ReadOnlyPerson p1, ReadOnlyPerson p2) {
        return p1.getName().fullName.toLowerCase().compareTo(p2.getName().fullName.toLowerCase());
    }

    public boolean equals(Object obj) {
        return this == obj;
    }
}