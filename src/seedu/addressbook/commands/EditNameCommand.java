package seedu.addressbook.commands;

public class EditNameCommand extends Command {
    public static final String COMMAND_WORD = "edit_name";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Modifies a persons name from the addressbook "
            + "Contact details can be marked private by prepending 'p' to the prefix.\n"
            + "Parameters: NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    private String oldPersonName, newPersonName;
    public EditNameCommand(String name, String password){
        this.oldPersonName = name;
        this.newPersonName = name;
    }
    @Override
    public CommandResult execute(){
        return new CommandResult("hi");
    }
}
