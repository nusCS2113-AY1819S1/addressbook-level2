package seedu.addressbook.data.tag;

import java.util.ArrayList;

public class Tagging {
    
    private static String ADD_TAG_FORMAT = "+ %1$s [%2$s]";
    private static String DELETE_TAG_FORMAT = "- %1$s [%2$s]";

    public static ArrayList<String> TagList = new ArrayList<String>();
    
    public static void addTag(String name, Tag addedTag){
        TagList.add(String.format(ADD_TAG_FORMAT,name,addedTag.tagName));
    }
    public static void deleteTag(String name, Tag delTag){
        TagList.add(String.format(DELETE_TAG_FORMAT,name,delTag.tagName));
        
    }
    
}
