package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Sorts all persons in the address book and lists all persons to the user.
 */
public class SortCommand extends ListCommand {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers sorted by name.\n"
            + "Example: " + COMMAND_WORD;



    @Override
    public CommandResult execute() {

        addressBook.sort();

        return super.execute();
    }

}
