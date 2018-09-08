package seedu.addressbook.commands;

import org.junit.Before;
import org.junit.Test;
import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

import java.util.*;

import static org.junit.Assert.*;
import static seedu.addressbook.ui.TextUi.DISPLAYED_INDEX_OFFSET;

public class EditCommandTest {
    private static final List<ReadOnlyPerson> EMPTY_PERSON_LIST = Collections.emptyList();
    private static final Set<String> EMPTY_STRING_SET = Collections.emptySet();
    private AddressBook emptyAddressBook;
    private AddressBook addressBook;

    private List<ReadOnlyPerson> emptyDisplayList;
    private List<ReadOnlyPerson> listWithEveryone;
    private List<ReadOnlyPerson> listWithSurnameDoe;

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

        emptyAddressBook = TestUtil.createAddressBook();
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);

        emptyDisplayList = TestUtil.createList();

        listWithEveryone = TestUtil.createList(johnDoe, janeDoe, davidGrant, samDoe);
        listWithSurnameDoe = TestUtil.createList(johnDoe, janeDoe, samDoe);
    }

    @Test
    public void execute_emptyAddressBook_returnsPersonNotFoundMessage() {
        assertDeletionFailsDueToNoSuchPerson(1, emptyAddressBook, listWithEveryone);
    }

    @Test
    public void execute_noPersonDisplayed_returnsInvalidIndexMessage() {
        assertDeletionFailsDueToInvalidIndex(1, addressBook, emptyDisplayList);
    }

    @Test
    public void execute_targetPersonNotInAddressBook_returnsPersonNotFoundMessage()
            throws IllegalValueException {
        Person notInAddressBookPerson = new Person(new Name("Not In Book"), new Phone("63331444", false),
                new Email("notin@book.com", false), new Address("156D Grant Road", false), Collections.emptySet());
        List<ReadOnlyPerson> listWithPersonNotInAddressBook = TestUtil.createList(notInAddressBookPerson);

        assertDeletionFailsDueToNoSuchPerson(1, addressBook, listWithPersonNotInAddressBook);
    }

    @Test
    public void execute_invalidIndex_returnsInvalidIndexMessage() {
        assertDeletionFailsDueToInvalidIndex(0, addressBook, listWithEveryone);
        assertDeletionFailsDueToInvalidIndex(-1, addressBook, listWithEveryone);
        assertDeletionFailsDueToInvalidIndex(listWithEveryone.size() + 1, addressBook, listWithEveryone);
    }

    @Test
    public void execute_validIndex_personIsDeleted() throws UniquePersonList.PersonNotFoundException {
        assertDeletionSuccessful(1, addressBook, listWithSurnameDoe);
        assertDeletionSuccessful(listWithSurnameDoe.size(), addressBook, listWithSurnameDoe);

        int middleIndex = (listWithSurnameDoe.size() / 2) + 1;
        assertDeletionSuccessful(middleIndex, addressBook, listWithSurnameDoe);
    }

    /**
     * Creates a new delete command.
     *
     * @param targetVisibleIndex of the person that we want to delete
     */
    private Command createEditCommand(int targetIndex,
                                              String name,
                                              String phone, boolean isPhonePrivate,
                                              String email, boolean isEmailPrivate,
                                              String address, boolean isAddressPrivate,
                                              Set<String> tags,
                                              AddressBook addressBook,
                                              List<ReadOnlyPerson> displayList) {

        try {
            EditCommand command = new EditCommand(targetIndex,
                    name,
                    phone, isPhonePrivate,
                    email, isEmailPrivate,
                    address, isAddressPrivate,
                    tags);
            command.setData(addressBook, displayList);

            return command;
        }
        catch (IllegalValueException ive) {
            return new IncorrectCommand(ive.getMessage());
        }
    }

    /**
     * Executes the command, and checks that the execution was what we had expected.
     */
    private void assertCommandBehaviour(Command editCommand, String expectedMessage,
                                        AddressBook expectedAddressBook, AddressBook actualAddressBook) {

        CommandResult result = editCommand.execute();

        assertEquals(expectedMessage, result.feedbackToUser);
        assertEquals(expectedAddressBook.getAllPersons(), actualAddressBook.getAllPersons());
    }

    /**
     * Asserts that the index is not valid for the given display list.
     */
    private void assertDeletionFailsDueToInvalidIndex(int invalidVisibleIndex, AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX;

        Command command = createEditCommand(invalidVisibleIndex,Name.EXAMPLE,
                                                    Phone.EXAMPLE, false,
                                                    Email.EXAMPLE, false,
                                                    Address.EXAMPLE, false,
                                                    EMPTY_STRING_SET, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index cannot be deleted, because that person
     * is not in the address book.
     */
    private void assertDeletionFailsDueToNoSuchPerson(int visibleIndex , AddressBook addressBook,
                                                      List<ReadOnlyPerson> displayList) {

        String expectedMessage = Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK;

        Command command = createEditCommand(visibleIndex,Name.EXAMPLE,
                Phone.EXAMPLE, false,
                Email.EXAMPLE, false,
                Address.EXAMPLE, false,
                EMPTY_STRING_SET, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, addressBook, addressBook);
    }

    /**
     * Asserts that the person at the specified index can be successfully deleted.
     *
     * The addressBook passed in will not be modified (no side effects).
     *
     * @throws UniquePersonList.PersonNotFoundException if the selected person is not in the address book
     */
    private void assertDeletionSuccessful(int targetVisibleIndex, AddressBook addressBook,
                                          List<ReadOnlyPerson> displayList) throws UniquePersonList.PersonNotFoundException {

        ReadOnlyPerson targetPerson = displayList.get(targetVisibleIndex - TextUi.DISPLAYED_INDEX_OFFSET);

        AddressBook expectedAddressBook = TestUtil.clone(addressBook);
        expectedAddressBook.removePerson(targetPerson);
        String expectedMessage = String.format(EditCommand.MESSAGE_SUCCESS, targetVisibleIndex, targetPerson);

        AddressBook actualAddressBook = TestUtil.clone(addressBook);

        Command command = createEditCommand(targetVisibleIndex,Name.EXAMPLE,
                Phone.EXAMPLE, false,
                Email.EXAMPLE, false,
                Address.EXAMPLE, false,
                EMPTY_STRING_SET, addressBook, displayList);
        assertCommandBehaviour(command, expectedMessage, expectedAddressBook, actualAddressBook);
    }

    @Test
    public void editCommand_invalidName_throwsException() {
        final String[] invalidNames = { "", " ", "[]\\[;]" };
        for (String name : invalidNames) {
            assertConstructingInvalidAddCmdThrowsException(name, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                    Address.EXAMPLE, true, EMPTY_STRING_SET);
        }
    }

    @Test
    public void addCommand_invalidPhone_throwsException() {
        final String[] invalidNumbers = { "", " ", "1234-5678", "[]\\[;]", "abc", "a123", "+651234" };
        for (String number : invalidNumbers) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, number, false, Email.EXAMPLE, true,
                    Address.EXAMPLE, false, EMPTY_STRING_SET);
        }
    }

    @Test
    public void addCommand_invalidEmail_throwsException() {
        final String[] invalidEmails = { "", " ", "def.com", "@", "@def", "@def.com", "abc@",
                                         "@invalid@email", "invalid@email!", "!invalid@email" };
        for (String email : invalidEmails) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, false, email, false,
                    Address.EXAMPLE, false, EMPTY_STRING_SET);
        }
    }

    @Test
    public void addCommand_invalidAddress_throwsException() {
        final String[] invalidAddresses = { "", " " };
        for (String address : invalidAddresses) {
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, address, true, EMPTY_STRING_SET);
        }
    }

    @Test
    public void addCommand_invalidTags_throwsException() {
        final String[][] invalidTags = { { "" }, { " " }, { "'" }, { "[]\\[;]" }, { "validTag", "" },
                                         { "", " " } };
        for (String[] tags : invalidTags) {
            Set<String> tagsToAdd = new HashSet<>(Arrays.asList(tags));
            assertConstructingInvalidAddCmdThrowsException(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE,
                    true, Address.EXAMPLE, false, tagsToAdd);
        }
    }

    /**
     * Asserts that attempting to construct an add command with the supplied
     * invalid data throws an IllegalValueException
     */
    private void assertConstructingInvalidAddCmdThrowsException(String name, String phone,
            boolean isPhonePrivate, String email, boolean isEmailPrivate, String address,
            boolean isAddressPrivate, Set<String> tags) {
        try {
            new AddCommand(name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate,
                    tags);
        } catch (IllegalValueException e) {
            return;
        }
        String error = String.format(
                "An add command was successfully constructed with invalid input: %s %s %s %s %s %s %s %s",
                name, phone, isPhonePrivate, email, isEmailPrivate, address, isAddressPrivate, tags);
        fail(error);
    }

    @Test
    public void addCommand_validData_correctlyConstructed() throws Exception {
        AddCommand command = new AddCommand(Name.EXAMPLE, Phone.EXAMPLE, true, Email.EXAMPLE, false,
                Address.EXAMPLE, true, EMPTY_STRING_SET);
        ReadOnlyPerson p = command.getPerson();

        // TODO: add comparison of tags to person.equals and equality methods to
        // individual fields that compare privacy to simplify this
        assertEquals(Name.EXAMPLE, p.getName().fullName);
        assertEquals(Phone.EXAMPLE, p.getPhone().value);
        assertTrue(p.getPhone().isPrivate());
        assertEquals(Email.EXAMPLE, p.getEmail().value);
        assertFalse(p.getEmail().isPrivate());
        assertEquals(Address.EXAMPLE, p.getAddress().value);
        assertTrue(p.getAddress().isPrivate());
        boolean isTagListEmpty = !p.getTags().iterator().hasNext();
        assertTrue(isTagListEmpty);
    }

    @Test
    public void addCommand_emptyAddressBook_addressBookContainsPerson() {
        Person p = TestUtil.generateTestPerson();
        AddCommand command = new AddCommand(p);
        AddressBook book = new AddressBook();
        command.setData(book, EMPTY_PERSON_LIST);
        CommandResult result = command.execute();
        UniquePersonList people = book.getAllPersons();

        assertTrue(people.contains(p));
        assertEquals(1, people.immutableListView().size());
        assertFalse(result.getRelevantPersons().isPresent());
        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, p), result.feedbackToUser);
    }

    @Test
    public void addCommand_addressBookAlreadyContainsPerson_addressBookUnmodified() throws Exception {
        Person p = TestUtil.generateTestPerson();
        AddressBook book = new AddressBook();
        book.addPerson(p);
        AddCommand command = new AddCommand(p);
        command.setData(book, EMPTY_PERSON_LIST);
        CommandResult result = command.execute();

        assertFalse(result.getRelevantPersons().isPresent());
        assertEquals(AddCommand.MESSAGE_DUPLICATE_PERSON, result.feedbackToUser);
        UniquePersonList people = book.getAllPersons();
        assertTrue(people.contains(p));
        assertEquals(1, people.immutableListView().size());
    }
}
