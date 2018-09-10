package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;
/**
 * Represents a Block of the address in the address book.
 * Guarantees: immutable
 */
public class Block {
    public final String value;

    /**
     * Do not validate valid input for now
     */
    public Block(String block) {
        this.value = block;
    }

    @Override
    public String toString() {
        return value;
    }
}