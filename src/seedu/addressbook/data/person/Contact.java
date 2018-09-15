package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Contact in the address book.
 * Guarantees: immutable; validity is checked as well
 */
public abstract class Contact {
    protected String trimmedValue;
    public String value;
    protected boolean isPrivate;

    /**
     * Validates given Contact
     *
     * @throws IllegalValueException if given contact is invalid.
     */
    protected Contact(String value, boolean isPrivate, String validRegex, String error) throws IllegalValueException {
        this.isPrivate = isPrivate;
        this.value = value;
        this.trimmedValue = value.trim();

        if (!trimmedValue.matches(validRegex)) {
            throw new IllegalValueException(error);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
