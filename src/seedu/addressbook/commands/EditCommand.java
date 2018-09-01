package seedu.addressbook.commands;


import seedu.addressbook.common.Messages;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;


/**
    Edit a person's phone number or email or address
 **/
public class EditCommand extends Command{

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": edit a person particular identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX parameter\n"
            + "Example: " + COMMAND_WORD + " 1 " + "number";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Person: %1$s";

    private final String parameter;

    /**
        Constructor for EditCommand
     **/
    public EditCommand(int targetVisibleIndex,String parameter){
        super(targetVisibleIndex);
        this.parameter=parameter;
    }

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson target = getTargetPerson();
            addressBook.removePerson(target);
            return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (UniquePersonList.PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
    }
}
