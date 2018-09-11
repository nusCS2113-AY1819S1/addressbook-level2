package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;
/**
 * Represents the Street of an address in the address book.
 * Guarantees: immutable
 */
public class Street {
    public final String value;

    /**
     * Do not validate valid input for now
     */
    public Street(String street) {
        this.value = street;
    }

    @Override
    public String toString() {
        return value;
    }
}