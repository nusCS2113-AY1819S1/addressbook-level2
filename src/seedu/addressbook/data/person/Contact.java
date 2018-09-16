package seedu.addressbook.data.person;

/**
 * Represents a Person's contact
 */
public class Contact {
    public String value;
    private boolean isPrivate;

    protected Contact() {}

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
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
}
