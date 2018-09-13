package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

import java.util.List;

public class SortedListCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        // extracting sorted list from the address book
        List<Person> allPersons = addressBook.getAllPersons().sortlist();

        // display result of sorting
        return new CommandResult(getMessageForSortSummary(allPersons), allPersons);
    }
}