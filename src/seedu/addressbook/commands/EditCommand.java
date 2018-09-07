package seedu.addressbook.commands;


import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;


/**
    Edit a person's phone number or email or address
 **/
public class EditCommand extends Command{

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": edit a person particular identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX parameter phonenumber/address/email\n"
            + "Example: " + COMMAND_WORD + " 1 " + "p/99999999";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "%1$s's particulars has been updated";

    private final String parameter;
    private final String value;

    /**
        Constructor for EditCommand
     **/
    public EditCommand(int targetVisibleIndex,String parameter,String value){
        super(targetVisibleIndex);
        this.parameter=parameter;
        this.value=value;
    }

    /**
     * Executes the command and returns the result.
     */
    @Override
    public CommandResult execute() throws IllegalValueException {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            switch(parameter) {
                case "p":
                    target.setPhone(value);
                    break;
                case "e":
                    target.setEmail(value);
                    break;
                case "a":
                    target.setAddress(value);
                    break;
            }
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, target.getName()));
        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
    }

}
