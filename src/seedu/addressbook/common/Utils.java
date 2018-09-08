package seedu.addressbook.common;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
     * Takes a Set<String> and returns a Set<String>, where all the strings are lowercase.
     */
    public static Set<String> ConvertStringSetToLower(Set<String> string_set){
        Set<String> lower_string_set = new HashSet<String>();
        for (String string : string_set) {
            lower_string_set.add(string.toLowerCase());
        }
        return lower_string_set;
    }

}
