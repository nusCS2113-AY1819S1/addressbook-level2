package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    public static String getStorageFileInfo(String storageFilePath) {
        return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }

    public static String getMessage(String message) {
        return addLinePrefix(message.replace("\n", LS + LINE_PREFIX));
    }

    public static String addLinePrefix(String message) {
        return LINE_PREFIX + message;
    }

    /** Returns a list of strings, formatted as an indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
