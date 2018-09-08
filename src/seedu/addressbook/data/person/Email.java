package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 */
public class Email extends Contact{

    public static final String EXAMPLE = "valid@e.mail";
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    public Email(String email, boolean isPrivate) throws IllegalValueException {
        super(email, isPrivate, EMAIL_VALIDATION_REGEX, MESSAGE_EMAIL_CONSTRAINTS);
    }
}
