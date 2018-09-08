package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Lists all persons in the address book to the user sorted by name.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers sorted by name.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        //Using Streams for readability
        List<ReadOnlyPerson> allSortedPersons = addressBook.getAllPersons().immutableListView()
                .stream().sorted(
                        Comparator.comparing((readOnlyPerson -> readOnlyPerson.getName().toString())))
                .collect(Collectors.toList());
        return new CommandResult(getMessageForPersonListShownSummary(allSortedPersons), allSortedPersons);
    }
}
