package seedu.addressbook.commands;

/**
 * Gives the size of the address book - number of persons.
 */
public class CheckCommand extends Command {

    public static final String COMMAND_WORD = "check";
    public static final String MESSAGE_USAGE = "Checks if Address book is empty.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS_1 = "Address book has persons!";
    private static final String MESSAGE_SUCCESS_2 = "Address book has no persons!" ;

    public CheckCommand() {}

    @Override
    public CommandResult execute() {
        if (addressBook.check()) {
            return new CommandResult(MESSAGE_SUCCESS_1);
        } else {
            return new CommandResult(MESSAGE_SUCCESS_2);
        }
    }
}