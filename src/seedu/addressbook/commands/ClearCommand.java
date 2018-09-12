package seedu.addressbook.commands;

import seedu.addressbook.ui.TextUi;

import java.util.Scanner;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = "Clears address book permanently.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";
    public static final String MESSAGE_NO_CLEAR = "Address book has not been cleared.";

    private final Scanner in = new Scanner(System.in);
    private TextUi ui = new TextUi();

    public ClearCommand() {}


    @Override
    public CommandResult execute() {
        System.out.print(ui.LINE_PREFIX + "Are you sure you want to clear the address book? (Y/N): ");
        char userResponse = in.next().charAt(0);
        if(userResponse == 'Y') {
            addressBook.clear();
            return new CommandResult(MESSAGE_SUCCESS);
        } else{
            return new CommandResult(MESSAGE_NO_CLEAR);
        }
    }
}
