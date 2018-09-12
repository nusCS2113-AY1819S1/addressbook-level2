package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    public String value;
    public boolean isPrivate;

    public Contact() throws IllegalValueException {
        this.value = " ";
        this.isPrivate = true;
    }

    public String toString() {
        return value;
    }

    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
