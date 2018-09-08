package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;

import java.util.HashSet;
import java.util.Set;
import static seedu.addressbook.ui.TextUi.DISPLAYED_INDEX_OFFSET;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

/**
 * Adds a person to the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits a person particular in the address book. "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: INDEX NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " 1 John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "Entry %1$d changed to: %2$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Person personIn;

    /**
     * Convenience constructor using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public EditCommand(int targetIndex,
                        String name,
                       String phone, boolean isPhonePrivate,
                       String email, boolean isEmailPrivate,
                       String address, boolean isAddressPrivate,
                       Set<String> tags) throws IllegalValueException {
        super(targetIndex);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        this.personIn = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(address, isAddressPrivate),
                tagSet
        );
    }

    public ReadOnlyPerson getPerson() {
        return personIn;
    }

    @Override
    public CommandResult execute() {
        try {
            final ReadOnlyPerson personOut = getTargetPerson();
            addressBook.editPerson(personOut, personIn);
            return new CommandResult(String.format(MESSAGE_SUCCESS, getTargetIndex(), personIn));
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
        }catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommandResult("Unknown Exception");
        }
    }

}
