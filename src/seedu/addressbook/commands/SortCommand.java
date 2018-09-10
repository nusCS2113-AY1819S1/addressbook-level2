package seedu.addressbook.commands;

import javafx.collections.transformation.SortedList;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort by Person name in the Address Book as a list with index number.\n"
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
