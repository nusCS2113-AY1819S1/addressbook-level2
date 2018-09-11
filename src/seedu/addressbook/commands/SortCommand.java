package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorts all persons in the address book to the user.
 */

public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book alphabetically.\n"
            + "Example: " + COMMAND_WORD;


   @Override
    public CommandResult execute(){
       return new CommandResult("");
   }

}