package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's date of birth in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDob(String)}
 */
public class DateOfBirth {

    public static final String EXAMPLE = "12-09-1998";
    public static final String MESSAGE_DOB_CONSTRAINTS = "Person dates of birth should be 3 numbers separated by '-'";
    public static final String DOB_VALIDATION_REGEX = "\\d+-\\d+-\\d+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given date of birth.
     *
     * @throws IllegalValueException if given date of birth string is invalid.
     */
    public DateOfBirth(String dob, boolean isPrivate) throws IllegalValueException {
        String trimmedDob = dob.trim();
        this.isPrivate = isPrivate;
        if (!isValidDob(trimmedDob)) {
            throw new IllegalValueException(MESSAGE_DOB_CONSTRAINTS);
        }
        this.value = trimmedDob;
    }

    /**
     * Returns true if a given string is a valid person date of birth.
     */
    public static boolean isValidDob(String test) {
        return test.matches(DOB_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateOfBirth // instanceof handles nulls
                && this.value.equals(((DateOfBirth) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
