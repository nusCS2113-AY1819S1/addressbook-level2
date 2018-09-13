package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Lists the first five persons in the address book to the user.
 */

public class TopFiveCommand extends Command{
    public static final String COMMAND_WORD = "topFive";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays first five persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;

    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        int size = allPersons.size();
        if(size < 5) {
            return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
        }
        else {
            List<ReadOnlyPerson> toBeDisplayed = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                toBeDisplayed.add(i, allPersons.get(i));
            }
            return new CommandResult(getMessageForPersonListShownSummary(toBeDisplayed), toBeDisplayed);
        }
    }
}
