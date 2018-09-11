package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;
/**
 * Represents the Unit of an address in the address book.
 * Guarantees: immutable
 */
public class Unit {
    public final String value;

    /**
     * Do not validate valid input for now
     */
    public Unit(String unit) {
        this.value = unit;
    }

    @Override
    public String toString() {
        return value;
    }
}