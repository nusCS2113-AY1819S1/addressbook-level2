package seedu.addressbook.commands;

import org.junit.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SortCommandTest {

    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_SET = Collections.emptySet();

    @Test
    public void sortCommand_emptyAddressBook(){
        //match success behavior when address book is empty
        assertSortCommandSuccessBehavior();

    }

    private void assertSortCommandSuccessBehavior(){
        SortCommand sortCommand = createSortCommand();
        AddressBook book = new AddressBook();
        sortCommand.setData(book,EMPTY_PERSON_LIST);
        CommandResult result = sortCommand.execute();

        assertEquals(SortCommand.MESSAGE_SUCCESS,result.feedbackToUser);
    }


    private SortCommand createSortCommand(){
        return new SortCommand();
    }
}
