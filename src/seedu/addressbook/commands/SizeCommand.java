package seedu.addressbook.commands;

/**
 * Displays the size of the address book.
 */
public class SizeCommand extends Command {

    public static final String COMMAND_WORD = "size";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Displays the current size of the address book.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Size of the address book is %1$s.";

    public SizeCommand() {}


    @Override
    public CommandResult execute() {
        return new CommandResult(String.format(MESSAGE_SUCCESS, addressBook.getSize()));
    }

}
