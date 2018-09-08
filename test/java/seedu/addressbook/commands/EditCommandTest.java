package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.*;

public class EditCommandTest {
    private static final Set<String> EMPTY_STRING_SET = Collections.emptySet();
    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSurnameDoe;
    private Person newPerson;
    final private int defaultTargetIndex = 1;
    @Before
    public void setUp() throws Exception {
        Person johnDoe = new Person(new Name("John Doe"), new Phone("61234567", false),
                new Email("john@doe.com", false), new Address("395C Ben Road", false), Collections.emptySet());
        Person janeDoe = new Person(new Name("Jane Doe"), new Phone("91234567", false),
                new Email("jane@doe.com", false), new Address("33G Ohm Road", false), Collections.emptySet());
        Person samDoe = new Person(new Name("Sam Doe"), new Phone("63345566", false),
                new Email("sam@doe.com", false), new Address("55G Abc Road", false), Collections.emptySet());
        Person davidGrant = new Person(new Name("David Grant"), new Phone("61121122", false),
                new Email("david@grant.com", false), new Address("44H Define Road", false),
                Collections.emptySet());
        newPerson = new Person(new Name("New Guy"), new Phone("1111111", false),
                new Email("new@guy.com", false), new Address("New Street", false), Collections.emptySet());

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
    }

    @Test
    public void editCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidEditCmdThrowsException(defaultTargetIndex,
                    name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Address.EXAMPLE, true, EMPTY_STRING_SET);
        }
    }

    @Test
    public void editCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidEditCmdThrowsException(defaultTargetIndex,
                    Name.EXAMPLE, number, false, Email.EXAMPLE, true,
                    Address.EXAMPLE, false, EMPTY_STRING_SET);
        }
    }

    @Test
    public void editCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidEditCmdThrowsException(defaultTargetIndex,
                    Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
                    Address.EXAMPLE, false, EMPTY_STRING_SET);
        }
    }

    @Test
    public void editCommand_invalidAddress_throwsException() {
        final String[] invalidAddresses = { "", " " };
        for (String address : invalidAddresses) {
            assertConstructingInvalidEditCmdThrowsException(defaultTargetIndex,
                    Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, address, true, EMPTY_STRING_SET);
        }
    }

    @Test
    public void editCommand_invalidTags_throwsException() {
        final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
                { "", " " } };
        for (String[] tags : invalidTags) {
            Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
            assertConstructingInvalidEditCmdThrowsException(defaultTargetIndex,
                    Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, Address.EXAMPLE, false, tagsToAdd);
        }
    }

    @Test
    public void editCommand_validData_correctlyConstructed() throws Exception {
        Person tempPerson = new Person(new Name(Name.EXAMPLE), new Phone(Phone.EXAMPLE, true),
                new Email(Email.EXAMPLE, false), new Address(Address.EXAMPLE, true),
                new HashSet<>());

        EditCommand command = createEditCommand(defaultTargetIndex, tempPerson);
        ReadOnlyPerson p = command.getPerson();
        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals(tempPerson.getName(), p.getName());
        assertEquals(tempPerson.getPhone(), p.getPhone());
        assertEquals(tempPerson.getEmail(), p.getEmail());
        assertEquals(tempPerson.getAddress(), p.getAddress());
        boolean isTagListEmpty = !p.getTags().iterator().hasNext();
        assertTrue(isTagListEmpty);
    }

    @Test
    public void execute_emptyAddressBook_returnsPersonNotFoundMessage() throws IllegalValueException {
        assertEditFailsDueToNoSuchPerson(1, emptyAddressBook, listWithEveryone);
    }

    @Test
    public void execute_noPersonDisplayed_returnsInvalidIndexMessage() throws IllegalValueException {
        assertEditFailsDueToInvalidIndex(1, addressBook, emptyDisplayList);
    }

    @Test
    public void execute_targetPersonNotInAddressBook_returnsPersonNotFoundMessage()
            throws IllegalValueException {
        Person notInAddressBookPerson = new Person(new Name("Not In Book"), new Phone("63331444", false),
                new Email("notin@book.com", false), new Address("156D Grant Road", false), Collections.emptySet());
        List<ReadOnlyPerson> listWithPersonNotInAddressBook = TestUtil.createList(notInAddressBookPerson);

        assertEditFailsDueToNoSuchPerson(1, addressBook, listWithPersonNotInAddressBook);
    }

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() throws IllegalValueException {
        assertEditFailsDueToInvalidIndex(0, addressBook, listWithEveryone);
        assertEditFailsDueToInvalidIndex(-1, addressBook, listWithEveryone);
        assertEditFailsDueToInvalidIndex(listWithEveryone.size() + 1, addressBook, listWithEveryone);
    }
    @Test
    public void execute_validIndex_personIsEdited() throws Exception{
        assertEditSuccessful(1, addressBook, listWithSurnameDoe);
        assertEditSuccessful(listWithSurnameDoe.size(), addressBook, listWithSurnameDoe);

        int middleIndex = (listWithSurnameDoe.size() / 2) + 1;
        assertEditSuccessful(middleIndex, addressBook, listWithSurnameDoe);
    }

    /**
     * Creates a new edit command.
     *
     * @param targetIndex of the person that we want to delete
     */
    private EditCommand createEditCommand(int targetIndex,
                                              String name,
                                              String phone, boolean isPhonePrivate,
                                              String email, boolean isEmailPrivate,
                                              String address, boolean isAddressPrivate,
                                              Set<String> tags,
                                              AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) throws IllegalValueException {

            EditCommand command = new EditCommand(targetIndex,
                    name,
                    phone, isPhonePrivate,
                    email, isEmailPrivate,
                    address, isAddressPrivate,
                    tags);
            command.setData(addressBook, displayList);

            return command;
    }

    /**
     * Creates a new edit command.
     * Calls overloaded createEditCommand
     * @param targetIndex of the person that we want to delete
     */
    private EditCommand createEditCommand(int targetIndex,
                                      Person personIn,
                                      AddressBook addressBook,
                                      List<ReadOnlyPerson> displayList) throws IllegalValueException {
            EditCommand command = createEditCommand(targetIndex,
                    personIn.getName().toString(),
                    personIn.getPhone().toString(), personIn.getPhone().isPrivate(),
                    personIn.getEmail().toString(), personIn.getEmail().isPrivate(),
                    personIn.getAddress().toString(), personIn.getAddress().isPrivate(),
                    EMPTY_STRING_SET, addressBook, displayList);
        return command;
    }

    /**
     * Creates a new edit command.
     *
     * @param targetIndex of the person that we want to delete
     */
    private EditCommand createEditCommand(int targetIndex,
                                          String name,
                                          String phone, boolean isPhonePrivate,
                                          String email, boolean isEmailPrivate,
                                          String address, boolean isAddressPrivate,
                                          Set<String> tags) throws IllegalValueException {

        EditCommand command = new EditCommand(targetIndex,
                name,
                phone, isPhonePrivate,
                email, isEmailPrivate,
                address, isAddressPrivate,
                tags);
        return command;
    }

    /**
     * Creates a new edit command.
     * Calls overloaded createEditCommand
     * @param targetIndex of the person that we want to delete
     */
    private EditCommand createEditCommand(int targetIndex,
                                          Person personIn) throws IllegalValueException {
        EditCommand command = createEditCommand(targetIndex,
                personIn.getName().toString(),
                personIn.getPhone().toString(), personIn.getPhone().isPrivate(),
                personIn.getEmail().toString(), personIn.getEmail().isPrivate(),
                personIn.getAddress().toString(), personIn.getAddress().isPrivate(),
                EMPTY_STRING_SET);
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

    /**
     * Asserts that the index is not valid for the given display list.
     */
    private void assertEditFailsDueToInvalidIndex(int invalidVisibleIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) throws IllegalValueException {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        EditCommand command = createEditCommand(invalidVisibleIndex, newPerson, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index cannot be edited, because that person
     * is not in the address book.
     */
    private void assertEditFailsDueToNoSuchPerson(int visibleIndex , AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) throws IllegalValueException {

        String expectedMessage = Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK;

        EditCommand command = createEditCommand(visibleIndex, newPerson, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index can be successfully edited.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
     */
    private void assertEditSuccessful(int targetVisibleIndex, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) throws Exception {
        final int actualIndex =  targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET;
        ReadOnlyPerson targetPerson = displayList.get(actualIndex);
        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        expectedAddressBook.editPerson(targetPerson, newPerson);

        String expectedMessage = String.format(EditCommand.MESSAGE_SUCCESS, targetVisibleIndex, newPerson);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        EditCommand command = createEditCommand(targetVisibleIndex, newPerson, actualAddressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }

    /**
     * Asserts that attempting to construct an add command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidEditCmdThrowsException(int targetIndex, String name,
                                                                 String phone, boolean isPhonePrivate,
                                                                 String email, boolean isEmailPrivate,
                                                                 String address, boolean isAddressPrivate,
                                                                 Set<String> tags) {
        try {
            new EditCommand(targetIndex, name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate,
                    tags);
        } catch (IllegalValueException e) {
            return;
        }
        String error = String.format(
                "An edit command was successfully constructed with invalid input: %s %s %s %s %s %s %s %s",
                name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
        fail(error);
    }
}
