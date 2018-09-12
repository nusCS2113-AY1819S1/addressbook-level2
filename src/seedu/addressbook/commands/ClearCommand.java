package seedu.addressbook.commands;

import seedu.addressbook.ui.TextUi;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = "Clears address book permanently.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";
    public static final String MESSAGE_CANCEL = "Address book is not cleared.";
    public static final String MESSAGE_INVALID = "Invalid input! Address book is not cleared.";

    private TextUi ui;

    public ClearCommand() {}


    @Override
    public CommandResult execute() {
        this.ui = new TextUi();
        String confirmationResult = ui.clearConfirmationMessage();

        // Confirm validity of the user's input (Case is ignored)
        // Inputs not recognized (not Y or N) are considered invalid input. Address book will not be cleared.
        if (confirmationResult.equalsIgnoreCase("y")) {
            addressBook.clear();
            return new CommandResult(MESSAGE_SUCCESS);
        }
        else if (confirmationResult.equalsIgnoreCase("n")){
            return new CommandResult(MESSAGE_CANCEL);
        }
        else {
            return new CommandResult(MESSAGE_INVALID);
        }
    }
}
