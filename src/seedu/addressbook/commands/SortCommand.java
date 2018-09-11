package seedu.addressbook.commands;

/**
 * Sort the list of contacts in address book
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of contacts in address book "
            + "in lexicographical order. ";
    public static final String MESSAGE_SUCCESS = "Address book sorted.";

    public SortCommand () {}

    @Override
    public CommandResult execute() {
        // Does nothing for now
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
