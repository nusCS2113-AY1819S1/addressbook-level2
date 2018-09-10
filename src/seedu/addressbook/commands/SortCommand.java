package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Lists all the persons in the addressbook to the user
 * in alphabetical / lexicographic order
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book in sorted order "
            + "as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

}
