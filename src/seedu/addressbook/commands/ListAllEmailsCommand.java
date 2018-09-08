package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.Email;

import java.util.ArrayList;
import java.util.List;


/**
 * Lists all persons in the address book to the user, regardless of privacy
 */
public class ListAllEmailsCommand extends Command {

    public static final String COMMAND_WORD = "listAllEmails";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all emails in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        ArrayList<Email> allEmails = new ArrayList<>(); //make a new method to extract these

        //Question: Where should I ideally put this helper function?
        for (ReadOnlyPerson person: allPersons) {
            allEmails.add(person.getEmail());
        }

        return new CommandResult(getMessageForEmailListShownSummary(allEmails), allEmails);
    }
}
