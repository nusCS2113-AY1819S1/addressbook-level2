package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Shows current total number of contacts in book.
 */
public class TotalCommand extends Command {

    public static final String COMMAND_WORD = "total";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the current number of contacts in the AB.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = " Contact(s) found";


    @Override
    public CommandResult execute() {
        int TotalContacts = addressBook.total();
        return new CommandResult(TotalContacts + "" + MESSAGE_SUCCESS);
    }
}
