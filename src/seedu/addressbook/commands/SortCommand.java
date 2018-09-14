package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.List;


/**
 * Lists all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort and displays all persons in the address book in alphabetical order as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().sortedListView().immutableListView();
        //Collections.sort(allPersons, (ReadOnlyPerson r1, ReadOnlyPerson r2) -> r1.getName().fullName.compareTo(r2.getName().fullName));
          //Collections.sort(allPersons, Comparator.comparing(ReadOnlyPerson::getName));
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
