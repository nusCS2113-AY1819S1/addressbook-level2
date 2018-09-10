package seedu.addressbook.commands;

import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EditCommandTest {
    private AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private TypicalPersons td = new TypicalPersons();
    private List<ReadOnlyPerson> listWithAllTypicalPersons = Arrays.asList(td.getTypicalPersons());

    /**
     * Test for invalid indexing of the edit command
     */
    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() {
        assertEditFailsDueToInvalidIndex(0, addressBook, listWithAllTypicalPersons);
        assertEditFailsDueToInvalidIndex(-1, addressBook, listWithAllTypicalPersons);
        assertEditFailsDueToInvalidIndex(listWithAllTypicalPersons.size() + 1
                                            ,addressBook, listWithAllTypicalPersons);
    }

    /**
     * Asserts that the index is not valid for the given display list.
     */
    private void assertEditFailsDueToInvalidIndex(int invalidVisibleIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        EditCommand command = createEditCommand(invalidVisibleIndex, addressBook, displayList,"p","99999999" );
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Creates a new edit command.
     *
     * @param targetVisibleIndex of the person that we want to edit
     */
    private EditCommand createEditCommand(int targetVisibleIndex, AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList,String parameter, String value) {

        EditCommand command = new EditCommand(targetVisibleIndex,parameter,value);
        command.setData(addressBook, displayList);

        return command;
    }


    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(EditCommand editCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = editCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }



}
