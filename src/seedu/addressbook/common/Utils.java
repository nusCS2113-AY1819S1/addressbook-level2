package seedu.addressbook.common;

import java.util.*;

/**
 * Utility methods
 */
public class Utils {

    /**
     * Returns true if any of the given items are null.
     */
    public static boolean isAnyNull(Object... items) {
        for (Object item : items) {
            if (item == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if every element the given collection are unique by {@link Object#equals(Object)}.
     */
    public static boolean elementsAreUnique(Collection<?> items) {
        final Set<Object> testSet = new HashSet<>();
        for (Object item : items) {
            final boolean itemAlreadyExists = !testSet.add(item); // see Set documentation
            if (itemAlreadyExists) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts all strings in a Collection to lowercase.
     *
     * @param toConvert source Collection
     * @return convert to lowercase
     */
    public static List<String> convertListToLower(Collection<String> toConvert) {
        ArrayList<String> converted = new ArrayList<>();
        for (String s: toConvert) {
            converted.add(s.toLowerCase());
        }
        return converted;
    }
}
