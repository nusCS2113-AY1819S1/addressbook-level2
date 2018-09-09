package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    /**
     * Base Class to build a Person's phone/email/address from.
     * This class holds the actual contact data, and some common functions
     */

    public final String value;
    protected boolean isPrivate;

    public Contact(String contact, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;

        String trimmedContact = contact.trim();
        this.value = trimmedContact;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
}
