package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

/**
 * Sort the list of contacts in address book
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of contacts in address book "
            + "in lexicographical order. ";
    public static final String MESSAGE_SUCCESS = "Address book sorted.";

    public SortCommand () {}

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        final String outputMessage = getMessageForPersonListShownSummary(allPersons) + "\n"
                + MESSAGE_SUCCESS;
        return new CommandResult(outputMessage, allPersons);
    }
}
