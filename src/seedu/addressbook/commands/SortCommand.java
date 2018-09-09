package seedu.addressbook.commands;

/**
 *  Sort and list all persons in the address book in alphabetical order to the user
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SORT_PERSON_SUCCESS = "Address Book Sorted!";

    @Override
    public CommandResult execute() {
        addressBook.sort();
        return new CommandResult(String.format(MESSAGE_SORT_PERSON_SUCCESS));
    }
}
