package seedu.addressbook.commands;

import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Edits the particulars of a person whose name matches exactly as typed in the command.
 * Keyword matching is case sensitive.
 *
 * NOTE: This class function only returns "found" if the name is valid, or "not found", if otherwise.
 *       For purpose of CS2113 LO Week 5.11
 */
public class EditCommand extends Command{
    public static final String COMMAND_WORD = "edit";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edit a person's profile whose name matches exactly" +
            " as typed in the command.\n" +
            "Parameters: [EXACT NAME OF THE PERSON AS IN THE RECORDS]\n" +
            "Example: " + COMMAND_WORD + " john smith";

    private String searchName;


    /**
     * Constructor for EditCommand
     * @param searchName
     */
    public EditCommand(String searchName){
        this.searchName = searchName;
    }

    @Override
    public CommandResult execute(){
        String result = (isPersonFound(searchName) ? searchName + " is found." : searchName + " is not found.");
        return new CommandResult(result);
    }
    /**
     * Checks if the specified person name is inside the address book.
     * @param searchName to check if the name is inside the address book
     * @return true if the person is found, and false if otherwise.
     */
    protected boolean isPersonFound(String searchName) {
        for(ReadOnlyPerson person : addressBook.getAllPersons()){
            if(Name.isValidName(searchName))
                return true;
        }
        return false;
    }
}
