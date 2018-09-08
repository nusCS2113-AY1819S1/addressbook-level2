package seedu.addressbook.data.person;

/**
 * Represents a standard contact parameter
 */
public class Contact {

    public String value;
    protected boolean isPrivate;

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.value.equals(((Name) other).value)); // state check
    }
}
