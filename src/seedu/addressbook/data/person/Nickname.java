package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's nickname in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Nickname {
    public static final String EXAMPLE = "Johnny";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person's nickname should be alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String nickname;

    public Nickname(String name) throws IllegalValueException {
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.nickname = name;
    }

    /**
     * Returns true if the given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public int hashCode() {
        return nickname.hashCode();
    }
}