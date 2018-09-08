package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact(address/phone/email) in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Contact {

    public final String value;
    private boolean isPrivate;
    public static String regex;
    public String constraints;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String regex, String constraints) throws IllegalValueException{
        this.isPrivate = isPrivate;
        this.regex = regex;
        this.constraints = constraints;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(constraints);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if a given string is a valid person contact (address/phone/email).
     */
    public static boolean isValidContact(String test) {
        return test.matches(regex);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
