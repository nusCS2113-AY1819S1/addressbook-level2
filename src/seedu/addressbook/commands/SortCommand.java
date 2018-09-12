package seedu.addressbook.commands;

import seedu.addressbook.common.NameComparator;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import seedu.addressbook.data.person.UniquePersonList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort base on name in alphabetical order.\n"
            + "Example: Sort";

    public SortCommand() {}
    public List<ReadOnlyPerson> SortList() {
        //Copy the unmodifiable array to a list
        List<ReadOnlyPerson> SortedList = new ArrayList<ReadOnlyPerson>(addressBook.getAllPersons().immutableListView());
        SortedList.sort(new NameComparator());
        return SortedList;
    }
    @Override
    public CommandResult execute () {
        List<ReadOnlyPerson> SortedList = SortList();
        return new CommandResult(getMessageForPersonListShownSummary(SortedList), SortedList);
    }
}
