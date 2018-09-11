package seedu.addressbook.commands;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

import java.util.*;


/**
 * Filters all persons in address book according to their respective tags
 * Tag matching is case sensitive.
 */
public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters all persons according to the "
            + "the tags provided\n"
            + "Parameters: TAG [TAG]...\n"
            + "Example: " + COMMAND_WORD + " work school";

    private final Set<Tag> tags;

    public FilterCommand(Set<String> tagsKeyword) throws IllegalValueException {
        tags = new HashSet<>();
        for (String tagName : tagsKeyword) {
            tags.add(new Tag(tagName));
        }
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<Tag> getKeywords() {
        return new HashSet<>(tags);
    }


    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTagsMatchingAnyKeyword(tags);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);

    }


    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param tags for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTagsMatchingAnyKeyword(Set<Tag> tags) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<Tag> personTags = new HashSet<>(person.getTags());
            if(containsAnyTag(tags, personTags)){
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    /**
     * Checks if the tags given in the filter command matches any tags of a given person
     *
     * @param person for searching
     * @param criteria for searching
     * @return list of persons found
     */
    private Boolean containsAnyTag(Set<Tag> person, Set<Tag> criteria){
        for(Tag tag: criteria){
            if(person.contains(tag)){
                return true;
            }
        }
        return false;
    }
}
