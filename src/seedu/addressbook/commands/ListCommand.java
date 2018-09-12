package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        //using immutableListView will return un-modifiable list
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        //commandResult have 2 variables:
        //first is String feedbackToUser (in this case show the number of people added)
        //second is private final List<? extends ReadOnlyPerson> relevantPersons

        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
