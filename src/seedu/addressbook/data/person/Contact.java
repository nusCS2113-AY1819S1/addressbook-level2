package seedu.addressbook.data.person;

public class Contact {
    protected boolean isPrivate;
    public String value;

    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }

}
