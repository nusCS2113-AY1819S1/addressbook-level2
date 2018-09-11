package seedu.addressbook.commands;
import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.List;

public class SortNameCommand extends Command {
    public static final String COMMAND_WORD = "sortName ";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted list.\n"
            + "Example: " + COMMAND_WORD;
    @Override
    public CommandResult execute() {
        addressBook.sortName();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForSortedList(allPersons), allPersons);
    }
}
