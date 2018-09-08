package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;

import java.util.HashSet;
import java.util.Set;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts people in address book. ";

    public static final String MESSAGE_SUCCESS = "List sorted";




    @Override
    public CommandResult execute() {
        UniquePersonList uniquePersonList = addressBook.sortByName();
        return new CommandResult(MESSAGE_SUCCESS, uniquePersonList.immutableListView());
    }

}
