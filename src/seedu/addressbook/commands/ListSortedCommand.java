package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;


/**
 * Lists all persons in the address book to the user.
 */
public class ListSortedCommand extends Command {

    public static final String COMMAND_WORD_SORTBYNAME = "sortedlist";
    public static final String MESSAGE_USAGE = COMMAND_WORD_SORTBYNAME
            + ": Displays all persons in the address book in sorted order as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD_SORTBYNAME;
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        /**
         * Transfer data to new list as allPersons is immutable.
         */
        List<ReadOnlyPerson> newList = new ArrayList<>(allPersons);
        /**
         * Sort name lexicographically.
         */
        newList.sort((ReadOnlyPerson o1, ReadOnlyPerson o2)->(o1.getName().toString().compareTo(o2.getName().toString())));

        return new CommandResult(getMessageForPersonListShownSummary(newList), newList);
    }
}
