package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;

public class ListSortedCommand extends Command {
    public static final String COMMAND_WORD = "listSorted";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers in their sorted order by name.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        // TODO: Add list sorted
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        Collections.sort(allPersons, Collections.reverseOrder());

        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

}
