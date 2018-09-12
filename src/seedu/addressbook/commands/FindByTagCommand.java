package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

/**
 * Finds and lists all persons in address book who contains the specified tag.
 * Keyword matching is not case sensitive.
 */
public class FindByTagCommand extends Command {

    public static final String COMMAND_WORD = "findbytag";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons who contain the "
            + "specified tag (non-case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [TAG]...\n"
            + "Example: " + COMMAND_WORD + " friends";

    private final String tag;

    public FindByTagCommand(String tag) {
        this.tag = tag.trim();
    }

    /**
     * Returns the tag to find in this command.
     */
    public String getTag() {
        return tag;
    }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingTag(tag);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book who contain the specified tag.
     *
     * @param tag for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingTag(String tag) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            for (Tag t : person.getTags()) {
                if (t.tagName.toLowerCase().equals(tag.toLowerCase())) {
                    matchedPersons.add(person);
                    break;
                }
            }
        }
        return matchedPersons;
    }

}
