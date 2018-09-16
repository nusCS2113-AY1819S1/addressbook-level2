package seedu.addressbook.data.person;

/**
 * Represents a piece of contact information
 */
public class Contact {
    public String value;
    private boolean isPrivate;

    /**
     * @param isPrivate the privacy setting of the contact information
     */
    public Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
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
}
