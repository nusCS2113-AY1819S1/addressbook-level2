package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;
/**
 * Represents the PostalCode of an address in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidPostalCodeName(String)}
 */
public class PostalCode {
    public final String value;

    /**
     * Do not validate valid input for now
     */
    public PostalCode(String postalCode) {
        this.value = postalCode;
    }

    @Override
    public String toString() {
        return value;
    }
}