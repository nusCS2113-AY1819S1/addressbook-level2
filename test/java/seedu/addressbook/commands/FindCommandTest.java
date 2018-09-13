package seedu.addressbook.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import static org.junit.Assert.assertEquals;

public class FindCommandTest {

    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() throws IllegalValueException {
        //same word, same case: matched
        assertFindCommandBehavior(new String[]{"Amy".toLowerCase()}, Collections.singletonList(td.amy));

        //same word, different case: matched
        assertFindCommandBehavior(new String[] {"aMy".toLowerCase()}, Collections.singletonList(td.amy));

        //partial word: not matched
        assertFindCommandBehavior(new String[]{"my".toLowerCase()}, Collections.emptyList());

        //multiple words: matched
        assertFindCommandBehavior(new String[]{"Amy".toLowerCase(), "Bill".toLowerCase(), "Candy".toLowerCase(), "Destiny".toLowerCase()},
                Arrays.asList(td.amy, td.bill, td.candy));

        //repeated keywords: matched
        assertFindCommandBehavior(new String[]{"Amy".toLowerCase(), "Amy".toLowerCase()}, Collections.singletonList(td.amy));

        //Keyword matching a word in address: not matched
        assertFindCommandBehavior(new String[]{"Clementi".toLowerCase()}, Collections.emptyList());
    }

    /**
     * Executes the find command for the given keywords and verifies
     * the result matches the persons in the expectedPersonList exactly.
     */
    private void assertFindCommandBehavior(String[] keywords, List<ReadOnlyPerson> expectedPersonList) {
        FindCommand command = createFindCommand(keywords);
        CommandResult result = command.execute();


        assertEquals(Command.getMessageForPersonListShownSummary(expectedPersonList), result.getFeedbackToUser());
    }

    private FindCommand createFindCommand(String[] keywords) {
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        FindCommand command = new FindCommand(keywordSet);
        command.setData(addressBook, Collections.emptyList());
        return command;
    }

}
