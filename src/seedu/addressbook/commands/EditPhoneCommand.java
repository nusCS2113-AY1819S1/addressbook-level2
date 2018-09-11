package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.person.Phone;

public class EditPhoneCommand extends Command {
    public static final String COMMAND_WORD = "edit_phone";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the phone number of a user.\n"
            + "Parameters: Old Phone n/New Phone\n"
            + "Example: " + COMMAND_WORD
            + " 88888888 n/81818181";
    private static final String MESSAGE_DUPLICATE = "Cannot update address book to same phone number";
    public static final String MESSAGE_SUCCESS = "Person updated: %1$s";
    private String oldPhone, newPhone;
    public EditPhoneCommand(String oldPhoneNo, String newPhoneNo){
        this.oldPhone = oldPhoneNo;
        this.newPhone = newPhoneNo;
    }
    @Override
    public CommandResult execute(){
        //PhoneList pList = addressBook.
        UniquePersonList people = addressBook.getAllPersons();
        ReadOnlyPerson toBeRemoved = null;
        //to loop thru every single person in the addressbook
        for(ReadOnlyPerson person: people.immutableListView()){
            //test to see if phone number exists in the addressbook
            if(person.getPhone().value.equals(this.oldPhone)){
                //myTestCase=1;
                toBeRemoved = person;
            }
        }
        if(toBeRemoved == null){
            return  new CommandResult(Messages.MESSAGE_PHONE_NOT_IN_ADDRESSBOOK+this.oldPhone);
        }

        try{
            Person newEntry = new Person(
                    toBeRemoved.getName(),
                    new Phone(this.newPhone),
                    toBeRemoved.getEmail(),
                    toBeRemoved.getAddress(),
                    toBeRemoved.getTags()
            );
        }

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
