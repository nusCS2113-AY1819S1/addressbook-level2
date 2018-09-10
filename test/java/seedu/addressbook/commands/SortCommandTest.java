package seedu.addressbook.commands;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;
import seedu.addressbook.util.TestUtil;

public class SortCommandTest {

    private AddressBook unsortedBook;
    private AddressBook sortedBook;

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

        unsortedBook = TestUtil.createAddressBook(johnDoe, janeDoe, davidGrant, samDoe);
        sortedBook = TestUtil.createAddressBook(davidGrant, janeDoe, johnDoe, samDoe);
    }

    /**
     * Test on sort method
     * Sorts the unsorted book and compare it with the already sorted book
     */
    @Test
    public void sortTesting() {
        assertSuccessfulSort(unsortedBook, sortedBook);
    }

    public void assertSuccessfulSort( AddressBook unsortedBook, AddressBook sortedBook) {

        unsortedBook.sortPersons();
        assertEquals(unsortedBook, sortedBook);
    }




}
