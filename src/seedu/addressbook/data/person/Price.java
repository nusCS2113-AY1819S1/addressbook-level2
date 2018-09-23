package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPrice(String)}
 */
public class Price {
    public static final String EXAMPLE = "3.95";
    public static final String MESSAGE_PRICE_CONSTRAINTS =
            "Price should be '9.56' or 139";
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";
    public static final String PRICE_VALIDATION_REGEX = "\\d+(.?)(\\d)?";


    public final String value;
    private boolean isPrivate;

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Price(String price, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedPrice = price.trim();
        if (!isValidPrice(trimmedPrice)) {
            throw new IllegalValueException(MESSAGE_PRICE_CONSTRAINTS);
        }
        this.value = trimmedPrice;
    }

    /**
     * Returns true if the given string is a valid person email.
     */
    public static boolean isValidPrice(String test) {
        return test.matches(PRICE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Price // instanceof handles nulls
                && this.value.equals(((Price) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
