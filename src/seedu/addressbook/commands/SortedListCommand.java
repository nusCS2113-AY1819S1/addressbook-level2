package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

public class SortedListCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        // extracting all objects from the Unique persons list and placing them in a new list for sorting
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        List<ReadOnlyPerson> sorting = new ArrayList<>(allPersons);

        // sorting done on person objects here
        sorting.sort((ReadOnlyPerson o1, ReadOnlyPerson o2)->o1.getName().toString().compareTo(o2.getName().toString()));

        // display result of sorting
        return new CommandResult(getMessageForPersonListShownSummary(sorting), sorting);
    }
}