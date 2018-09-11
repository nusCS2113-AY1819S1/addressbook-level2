package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.Comparator;
import java.util.List;
import java.util.Collections;


public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted list with index numbers.\n"
            + "Example: " + COMMAND_WORD;
    @Override
    public CommandResult execute() {
//       UniquePersonList allPersons = addressBook.getAllPersons();
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().SortedimmutableListView();
//        Collections.sort(allPersons, (ReadOnlyPerson o1, ReadOnlyPerson o2) -> (o1.getName().toString().toLowerCase().compareTo(o2.getName().toString().toLowerCase())));
//        Collections.sort(allPersons, new Comparator<ReadOnlyPerson>() {
//            @Override
//            public int compare(ReadOnlyPerson o1, ReadOnlyPerson o2) {
//                return (o1.getName().toString().toLowerCase()).compareTo(o2.getName().toString().toLowerCase());
//            }
//        });
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
