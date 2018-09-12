package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is NOT case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (NOT case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Set<String> keywords;

    public FindCommand(Set<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * Returns a copy of keywords, in small case, in this command.
     */
    public Set<String> ToSmallCaseKeywords(Set<String> keywords) {
        //Converting set to array to iterate through
        String[] keywordsArray = keywords.toArray(new String[keywords.size()]);
        for (int i = 0; i < keywordsArray.length; i++) {
            keywordsArray[i] = keywordsArray[i].toLowerCase();
        }
        Set<String> keywordsInSmallCase = new HashSet<>(Arrays.asList(keywordsArray));
        return keywordsInSmallCase;
    }

    /**
     * Returns a copy of keywords in this command.
     */
    public Set<String> getKeywords() { return new HashSet<>(keywords); }

    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithNameContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
    }

    /**
     * Retrieves all persons in the address book whose names contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithNameContainingAnyKeyword(Set<String> keywords) {
        Set<String> keywordsInSmallCase;
        keywordsInSmallCase = ToSmallCaseKeywords(keywords);
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            final Set<String> wordsInNameInSmallCase = new HashSet<>(person.getName().getWordsInNameInSmallCase());
            if (!Collections.disjoint(wordsInNameInSmallCase, keywordsInSmallCase)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
