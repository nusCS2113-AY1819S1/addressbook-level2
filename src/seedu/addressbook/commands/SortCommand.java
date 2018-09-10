package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    private static Comparator<Person> customComparator = new Comparator<Person> () {
        public int compare(Person person1, Person person2) {
            String person1Name = person1.getName().toString().toUpperCase();
            String person2Name = person2.getName().toString().toUpperCase();

            return person1Name.compareTo(person2Name);

        }
    };
    @Override
    public CommandResult execute(){
        List<Person> allPersons = addressBook.getAllPersons().mutableListView();   
        allPersons.sort(customComparator);
        
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }   
}
