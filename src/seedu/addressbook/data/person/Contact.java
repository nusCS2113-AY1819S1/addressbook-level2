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
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
