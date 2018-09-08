package seedu.addressbook.commands;

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = "Sorts the current list according to name.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been sorted!";

    public SortCommand(){}

    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
