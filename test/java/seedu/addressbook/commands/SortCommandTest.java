package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.ui.TextUi;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private AddressBook emptyAddressBook;
    private AddressBook addressBook;
    private AddressBook sortedAddressBookWithDiffSize;

    private AddressBook sortedAddressBook;

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
        addressBook = TestUtil.createAddressBook(johnDoe, janeDoe, samDoe, davidGrant);
        sortedAddressBook = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe, samDoe);
        sortedAddressBookWithDiffSize = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe);
    }



    @Test
    public void testSortCommand() {
        addressBook.sort();

        TestIsTrue(addressBook, sortedAddressBook);
        TestIsFalse(addressBook, emptyAddressBook);
        TestIsFalse(addressBook, sortedAddressBookWithDiffSize);
    }

    public void TestIsTrue(AddressBook addressBook, AddressBook testAddressBook) {
        assertEquals(addressBook, testAddressBook);
    }

    public void TestIsFalse(AddressBook addressBook, AddressBook testAddressBook) {
        assertNotEquals(addressBook, testAddressBook);
    }
}
