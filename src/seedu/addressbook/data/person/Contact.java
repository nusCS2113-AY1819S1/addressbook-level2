package seedu.addressbook.data.person;
/**
 * Represents an person's contact.
 * Guarantees: immutable;
 */
public class Contact {
    private final String value;
    protected boolean isPrivate;
    Contact(String value, boolean isPrivate){
        this.value = value.trim();
        this.isPrivate = isPrivate;
    }
    public String getValue() {
        return value;
    }
    public boolean isPrivate() {
        return isPrivate;
    }
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    public String toString() {
        return value;
    }
    public int hashCode() {
        return value.hashCode();
    }
}