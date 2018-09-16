package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

public class FindByTagCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindByTagCommandBehavior("test", Arrays.asList(td.dan));

        //same word, different case: matched
        assertFindByTagCommandBehavior("TeSt", Arrays.asList(td.dan));

        //no tag found: not matched
        assertFindByTagCommandBehavior("123", Collections.emptyList());

    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindByTagCommandBehavior(String tag, List<ReadOnlyPerson> expectedPersonList) {
        FindByTagCommand command = createFindByTagCommand(tag);
        CommandResult result = command.execute();

        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.getFeedbackToUser());
    }

    private FindByTagCommand createFindByTagCommand(String tag) {
        FindByTagCommand command = new FindByTagCommand(tag);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
