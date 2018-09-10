package seedu.addressbook.commands;

import seedu.addressbook.data.tag.Tagging;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Exits the program.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";
    
    @Override
    public CommandResult execute() {
        StringBuilder tagReport = new StringBuilder();

        for(String tag : Tagging.TagList){
            tagReport.append(tag).append("\n");
        }

        return new CommandResult(tagReport + MESSAGE_EXIT_ACKNOWLEDGEMENT);
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }
}
