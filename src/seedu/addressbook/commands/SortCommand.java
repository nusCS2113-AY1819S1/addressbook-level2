package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.*;

public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sort by Person Name in the Address Book as a list with index number.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_VIEW_SORTED_PERSONS_DETAIL = "%1$d. %2$s\n";

    @Override
    public CommandResult execute() {
        //using immutableListView will return un-modifiable list
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();

        //commandResult have 2 variables:
            //first is String feedbackToUser (in this case show the number of people added)
            //second is private final List<? extends ReadOnlyPerson> relevantPersons

        Map <String, ReadOnlyPerson> allSortedPersons_map = new HashMap<>();
        for (ReadOnlyPerson person: allPersons) {
            String name = person.getName().fullName;
            allSortedPersons_map.put(name, person);
        }
        //TODO: Put the value into the List<ReadOnlyPerson>
        TreeMap<String, ReadOnlyPerson> allSortedPersons_treemap = new TreeMap<>();
        allSortedPersons_treemap.putAll(allSortedPersons_map);
        System.out.println(allSortedPersons_treemap.firstKey());
        Set keys = allSortedPersons_treemap.keySet();
        List<ReadOnlyPerson> allSortedPersons_list = new ArrayList<>();
        for (Iterator itr = keys.iterator(); itr.hasNext();){
            String key = (String) itr.next();
            ReadOnlyPerson value = allSortedPersons_treemap.get(key);
            allSortedPersons_list.add(value);
        }
        return new CommandResult(getMessageForPersonListShownSummary(allSortedPersons_list), allSortedPersons_list);
    }
}
