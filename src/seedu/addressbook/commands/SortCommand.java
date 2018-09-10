package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the current list in alphabetical order based on names of all persons.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sortList();
        return new CommandResult(getMessageForSortSummary(allPersons), allPersons);
    }
}
