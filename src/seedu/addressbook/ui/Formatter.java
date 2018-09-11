package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;

/**
 * Formatter for Text UI of the application.
 */
public class Formatter {

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /**Formats a string as a viewable storage file info.*/
    public static String formatStorageFileInfo(String storageFilePath) {
        return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }

    /**Formats a string as a viewable indexed list item.*/
    public static String formatIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}