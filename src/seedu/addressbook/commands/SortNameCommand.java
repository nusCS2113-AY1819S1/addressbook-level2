package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.List;

public class SortNameCommand extends Command{

    public static final String COMMAND_WORD = "sortname";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts all data of persons in address book "
            + "in alphabetical order according to their name.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SORT_ACKNOWEDGEMENT = "Sorting Address Book as requested ...";

    public static class nameComparator implements Comparator<Person> {
        public int compare(Person s1, Person s2){
            int compareValue = s1.getName().fullName.compareTo(s2.getName().fullName);
            return compareValue;
        }
    }

    @Override
    public CommandResult execute() {
        Comparator<Person> NameCompare = new nameComparator();
        addressBook.sort(NameCompare);

        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }

}
