package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

/**
 * Lists all persons in the address book to the user in sorted order by name.
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book in sorted order by name.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedPersons = sortPersonsByName();
        return new CommandResult(getMessageForSortedListShownSummary(sortedPersons), sortedPersons);
    }

    /**
     * Sort all persons in the address book by name in alphabetical order.
     *
     * @return list of persons found in sorted order by name alphabetical order
     */
    private List<ReadOnlyPerson> sortPersonsByName() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> sortedPersons = new ArrayList<ReadOnlyPerson>(allPersons);

        Collections.sort(sortedPersons, new Comparator<ReadOnlyPerson>() {
            public int compare(ReadOnlyPerson one, ReadOnlyPerson other) {
                String oneName = one.getName().fullName;
                String otherName = other.getName().fullName;
                return oneName.compareTo(otherName);
            }
        });

        return sortedPersons;
    }


}
