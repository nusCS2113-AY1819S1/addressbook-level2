package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
/
/**
 * Edits a person's email in the address book
 */
public class EditEmailCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the person's email identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX\n"
            + "Example: " + COMMAND_WORD + " 1";


    public static final String EMAIL_EDIT_PERSON_SUCCESS = "Edited Email: %1$s";
    private static final String MESSAGE_DUPLICATE = "The Old Email and the New Email are the same";

    //public EditEmailCommand(int targetVisibleIndex)  {super(targetVisibleIndex);}
    private String newEmail;

    public EditEmailCommand(string newEmail){
        this.newEmail=newEmail;
    }

    @Override
    public CommandResult execute(){
        try {
            final ReadOnlyPerson target = getTargetPerson();
            //addressBook.removePerson(target);

            Person newPerson = new Person(
                target.getName(),
                target.getPhone(),
                new Email(this.newEmail),
                target.getAddress(),
                target.getTags()
            );
            addressBook.addPerson(newPerson);
            addressBook.removeperson(target);
            return new CommandResult(String.format(EMAIL_EDIT_PERSON_SUCCESS, target));
        }
        catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        }
        /*catch (UniquePersonList.DuplicatePersonException dpe){
            return new CommandResult(MESSAGE_DUPLICATE);
        }*/

}
