package seedu.addressbook.data.tag;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaggingTest{

    @Test
    public void testAddTag() throws Exception{
        Tag testTag = new Tag("Friend");
        String testName = "John Doe";
        Tagging.addTag(testName,testTag);
        assertEquals("+ John Doe [Friend]", Tagging.TagList.get(1));
    }

    @Test
    public void deleteTag() throws Exception{
        Tag testTag = new Tag("Friend");
        String testName = "John Doe";
        Tagging.deleteTag(testName,testTag);
        assertEquals("- John Doe [Friend]", Tagging.TagList.get(0));
    }

}