package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {
    private boolean isPrivate;
    private String value;
    public Contact(){
    }

    /**
     * Validates given contact data like phone, address and email address.
     *
     * @throws IllegalValueException if given phone/address/email address string is invalid.
     */
    public Contact(String contactData, boolean isPrivate, String MESSAGE_CONSTRAINTS, String VALIDATION_REGEX) throws IllegalValueException {
        this.isPrivate = isPrivate;

        String trimmedContactData = contactData.trim();

        if (!isValidContact(trimmedContactData, VALIDATION_REGEX)) {
            throw new IllegalValueException(MESSAGE_CONSTRAINTS);
        }

        this.value = trimmedContactData;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Returns true if the given string is a valid person phone number or email address or address.
     */
    public static boolean isValidContact(String test, String VALIDATION_REGEX) {
        return test.matches(VALIDATION_REGEX);
    }
}
