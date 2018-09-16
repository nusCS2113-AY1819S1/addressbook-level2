package seedu.addressbook.data.person;

public class Contact {

    public String value = null;
    private boolean isPrivate;

    public Contact(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    @Override
    public String toString() {
        return value;
    }
}
