package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/**
 *  Sort and list all persons in the address book in alphabetical order to the user
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts and displays all persons in address book in alphabetical order"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> sortList = new ArrayList<>(allPersons);
        Collections.sort(sortList, new Comparator<ReadOnlyPerson>() {
            @Override
            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
                return o1.getName().toString().compareTo(o2.getName().toString());
            }
        });
        return new CommandResult(getMessageForPersonListShownSummary(sortList), sortList);
    }
}
