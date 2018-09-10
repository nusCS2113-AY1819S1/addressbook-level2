package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * A class containing the implementations of Contact
 */
public class Contact {
    public final String value;
    protected boolean isPrivate;
    //private final String trimmedValue;
    public  Contact(String value, Boolean isPrivate)  {
        this.isPrivate = isPrivate;
        this.value = value.trim();
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
