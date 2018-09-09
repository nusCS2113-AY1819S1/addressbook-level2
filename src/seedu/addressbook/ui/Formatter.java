package seedu.addressbook.ui;
import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

public class Formatter {

    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    public static String formatStorageFile(String storageFilePath){
        return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }
    
    public static String formatIndexedListItem(int visibleIndex, String listItem){
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
}
