package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sorts contacts within AddressBook for the user
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted in ascending order list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedPersons = addressBook.getAllPersons().sortedListView();
        return new CommandResult(getMessageForSortedPersonListShownSummary(sortedPersons), sortedPersons);
    }
}
