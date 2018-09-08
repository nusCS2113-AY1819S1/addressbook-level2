package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;
import seedu.addressbook.util.TypicalPersons;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    private AddressBook unsortedAddressBook;
    private AddressBook sortedAddressBook;

    private List<ReadOnlyPerson> listWithUnsortedPersons;
    private List<ReadOnlyPerson> listWithSortedPersons;


    @Before
    public void setUp() throws Exception {
        TypicalPersons td = new TypicalPersons();

        sortedAddressBook = td.getTypicalAddressBook();
        unsortedAddressBook = TestUtil.createAddressBook(td.candy, td.amy, td.bill, td.dan);

        listWithSortedPersons = Arrays.asList(td.getTypicalPersons());
        listWithUnsortedPersons = Arrays.asList(td.candy, td.amy, td.bill, td.dan);
    }

    @Test
    public void sortCommand_sortsAddressBookCorrectly() {
        SortCommand sortCommand = new SortCommand();
        SortCommand redundantCommand = new SortCommand();
        sortCommand.setData(unsortedAddressBook, listWithUnsortedPersons);

        // sortedAddressBook is already sorted when created.
        SortCommand expectedCommand = new SortCommand();
        redundantCommand.setData(sortedAddressBook, listWithSortedPersons);


        CommandResult expectedResult = redundantCommand.execute();
        CommandResult actualResult = sortCommand.execute();

        //Same size
        assertEquals(expectedResult.feedbackToUser,actualResult.feedbackToUser);

        //Same contents (ie : Sorted correctly)
        actualResult.getRelevantPersons().ifPresent(readOnlyPersons -> {
            for ( int index = 0; index < readOnlyPersons.size(); index++) {
                assertEquals(listWithSortedPersons.get(index).getName(), readOnlyPersons.get(index).getName());
            }
        });
    }

}

