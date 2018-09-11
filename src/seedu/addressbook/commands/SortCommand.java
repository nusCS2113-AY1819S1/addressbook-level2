package seedu.addressbook.commands;

/**
 * List all persons in the address book in alphabetical order of their names to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list in "
            + "alphabetical order of their names with index numbers.\n"
            + "Example: " + COMMAND_WORD;
}
