package seedu.addressbook.commands;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.util.TypicalPersons;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class EditCommandTest {
    private final AddressBook addressBook = new TypicalPersons().getTypicalAddressBook();
    private final TypicalPersons td = new TypicalPersons();

    @Test
    public void execute() {
        //same word, same case: matched
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
    /*private void assertEditCommandBehaviour(DeleteCommand deleteCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = deleteCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }*/



}
