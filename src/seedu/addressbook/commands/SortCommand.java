package seedu.addressbook.commands;
import seedu.addressbook.data.person.ReadOnlyPerson;
import java.util.List;

/**
 * Sort contact list of the addressbook
 */

public class SortCommand extends Command{
    public static final String COMMAND_WORD="sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort and display the contact in the addressbook in ascending order.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute(){
        List<ReadOnlyPerson>sortNames=addressBook.getAllPersons().sortedListView();
        return new CommandResult(getMessageForSortedPersonListShownSummary(sortNames), sortNames);
    }
}
