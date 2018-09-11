package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.List;

/**
 * Sort all persons in the lexicographical order.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort all persons in the address book in lexicographical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sortedImmutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
