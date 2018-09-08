package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 */
public class Phone extends Contact{

    public static final String EXAMPLE = "123456789";
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person phone numbers should only contain numbers";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";

    public Phone(String phone, boolean isPrivate) throws IllegalValueException {
        super(phone, isPrivate, PHONE_VALIDATION_REGEX, MESSAGE_PHONE_CONSTRAINTS);
    }
}
