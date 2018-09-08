package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 */
public class Address extends Contact{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public Address(String address, boolean isPrivate) throws IllegalValueException {
        super(address, isPrivate, ADDRESS_VALIDATION_REGEX, MESSAGE_ADDRESS_CONSTRAINTS);
    }
}
