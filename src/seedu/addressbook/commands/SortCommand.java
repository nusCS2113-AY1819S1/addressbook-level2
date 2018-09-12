package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort all persons in the address book\n"
            + "Example: " + COMMAND_WORD + ".";

    @Override
    public CommandResult execute() {
        addressBook.sortContact();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        return new CommandResult(getMessageForSortedPersonListShownSummary(allPersons), allPersons);
    }


}
