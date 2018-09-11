package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;

public class TotalCommand extends Command {

    public static final String COMMAND_WORD = "total";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the total number of people saved in your address book.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonTotalShownSummary(allPersons));
    }
}