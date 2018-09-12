package seedu.addressbook.commands;
import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.List;
/**
 * Sorts all persons in the address book to the user.
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all people in the address book as a sorted ascending list with index numbers.\n"
            + "Example: " + COMMAND_WORD;
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> sortedPersons = addressBook.getAllPersons().sortedListView();
        return new CommandResult(getMessageForPersonListShownSummary(sortedPersons), sortedPersons);
    }
}