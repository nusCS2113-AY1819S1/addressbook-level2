package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;

public class EditNameCommand extends Command {
    public static final String COMMAND_WORD = "edit_name";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Modifies a persons name from the addressbook "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";
    private static final String MESSAGE_DUPLICATE = "Cannot update address book to same name";
    public static final String MESSAGE_SUCCESS = "Person updated: %1$s";
    private String oldPersonName, newPersonName;
    public EditNameCommand(String name, String newName){
        this.oldPersonName = name;
        this.newPersonName = newName;
    }
    @Override
    public CommandResult execute(){
        UniquePersonList people = addressBook.getAllPersons();
        ReadOnlyPerson toBeRemoved = null;
        for(ReadOnlyPerson person: people.immutableListView()){
            if(person.getName().fullName.equals(this.oldPersonName)){
                toBeRemoved = person;
            }
        }
        if(toBeRemoved == null){
            return  new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK+this.oldPersonName);
        }
        try {
            Person newEntry = new Person(
                    new Name(this.newPersonName),
                    toBeRemoved.getPhone(),
                    toBeRemoved.getEmail(),
                    toBeRemoved.getAddress(),
                    toBeRemoved.getTags()
            );
            addressBook.addPerson(newEntry);
            addressBook.removePerson(toBeRemoved);
            return new CommandResult(String.format(MESSAGE_SUCCESS, newEntry));
        } catch (UniquePersonList.DuplicatePersonException dpe){
            return new CommandResult(MESSAGE_DUPLICATE);
        } catch (UniquePersonList.PersonNotFoundException cpe){
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK+this.oldPersonName);
        } catch (IllegalValueException ive){
            return new CommandResult(ive.getMessage());
        }
    }
}
