package seedu.addressbook.data.person;

public class Message {
    public static final String EXAMPLE = "This is a test message.";
    public final String fullMessage;

    public Message(String message) {
        if(message != null && message != "") {
            this.fullMessage = message.trim();
        }else{
            this.fullMessage = null;
        }
    }

    public boolean exist(){
        if(this.fullMessage == null || this.fullMessage == ""){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return fullMessage;
    }

    @Override
    public int hashCode() {
        return fullMessage.hashCode();
    }
}
