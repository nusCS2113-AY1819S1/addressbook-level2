package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.List;

/**
 * Lists all the persons in the addressbook to the user
 * in alphabetical / lexicographic order (name)
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book in sorted order "
            + "as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        allPersons.sorted();
        List<ReadOnlyPerson> allSortedPeople = allPersons.immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allSortedPeople), allSortedPeople);
    }

}
