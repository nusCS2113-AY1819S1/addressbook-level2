package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address extends Contact implements Printable{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Invalid address entered. Address must be in the format " 
                                                            +"a/BLOCK, STREET, UNIT, POSTAL_CODE\n"
                                                            + "Example: a/123, Clementi Ave 3, #12-34, 231534";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;
    private Block blockNo;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] splittedAddress = address.split(",",0);
        if(splittedAddress.length != 4){
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        initialiseAddress(isPrivate, splittedAddress);
//        if (!isValidAddress(trimmedAddress)) {
//            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
//        }
        this.value = trimmedAddress;
    }
    /**Initialises the address with its respective members */
    private void initialiseAddress(boolean isPrivate, String[] splittedAddress) {
        this.blockNo = new Block(splittedAddress[0]);
        this.street = new Street(splittedAddress[1]);
        this.unit = new Unit(splittedAddress[2]);
        this.postalCode = new PostalCode(splittedAddress[3]);
        this.isPrivate = isPrivate;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
//    public static boolean isValidAddress(String test) {
//        return test.matches(ADDRESS_VALIDATION_REGEX);
//    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**Printable methods */
    @Override
    public String getPrintableString() {
        return " Address: " + value;
    }
}
