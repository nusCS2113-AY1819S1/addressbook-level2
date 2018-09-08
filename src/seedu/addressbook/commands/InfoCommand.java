package seedu.addressbook.commands;

public class InfoCommand extends Command{
    public static final String COMMAND_WORD= "info";
    public static final String MESSAGE_USAGE= COMMAND_WORD+": print out several information"+"\n"+"Example: "+COMMAND_WORD ;
    public static final String INFO ="This is the addressbook level2 version 0.1 "
    + "\n"+ "Developed by Zeng Hao(Oscar)";

    public InfoCommand () {}
    @Override
    public CommandResult execute() {
        return new CommandResult(INFO);
    }

}
