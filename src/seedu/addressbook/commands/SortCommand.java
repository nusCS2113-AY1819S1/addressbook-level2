package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

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
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
