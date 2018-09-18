package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import java.util.Collections;
import java.util.List;

/**
 * Sorts the list of contacts in address book.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of contacts in address book "
            + "in lexicographical order.\n" + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SUCCESS = "Address book sorted.";

    public SortCommand () {}

    @Override
    public CommandResult execute() {
        sortContacts(addressBook.getAllPersons());
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        final String outputMessage = getMessageForPersonListShownSummary(allPersons) + "\n"
                + MESSAGE_SUCCESS;
        return new CommandResult(outputMessage, allPersons);
    }

    /**
     * This sorts the actual underlying ArrayList in the UniquePersonList instance passed in here
     *
     * @param uniquePersonList
     */
    private void sortContacts(UniquePersonList uniquePersonList) {
        List<Person> listToBeSorted = uniquePersonList.getInternalList();

        Collections.sort(listToBeSorted, Person.personNameComparator);

        try {
            UniquePersonList newList = new UniquePersonList(listToBeSorted);
            addressBook.replaceAllPersons(newList);
        } catch (UniquePersonList.DuplicatePersonException dpe) {
        }
    }
}
