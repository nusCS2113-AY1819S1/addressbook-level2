package seedu.addressbook.data.person;

public class Contact {
    public String value;
    private boolean isPrivate;

    public Contact(String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
    }
//    public String getValue() {
//        return value;
//    }
//    public boolean getIsPrivate() {
//        return isPrivate;
//    }
//    public void setValue(String value) {
//        this.value = value;
//    }
//    public void setIsPrivate(boolean isPrivate) {
//        this.isPrivate = isPrivate;
//    }

    public String toString() { return value; }
    public int hashCode() { return value.hashCode(); }
    public boolean isPrivate() {
        return isPrivate;
    }
}


