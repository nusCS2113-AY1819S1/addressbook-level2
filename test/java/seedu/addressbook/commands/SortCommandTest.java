package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;

public class SortCommandTest {

    private TypicalPersons sortedTypicalPersons = new TypicalPersons();
    private TypicalPersons jumbledTypicalPersons = new TypicalPersons();
    private AddressBook typicalSortedAddressBook = sortedTypicalPersons.getTypicalSortedAddressBook();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(sortedTypicalPersons.getTypicalPersons());

    @Test
    public void execute_SortCommand() {
        SortCommand sortCommand = new SortCommand();
        AddressBook jumbledAddressBook = jumbledTypicalPersons.getTypicalJumbledAddressBook();
        sortCommand.setData(jumbledAddressBook, listWithAllTypicalPersons);
        sortCommand.execute();
        assertSortCommandThrowsException(sortCommand.addressBook);
    }

    private void assertSortCommandThrowsException(AddressBook jumbledAddressBook) {
        Boolean isEqual = jumbledAddressBook.equals(typicalSortedAddressBook);
        if (!isEqual) {
            fail("Fail to sort properly");
        }
    }
}
