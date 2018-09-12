package seedu.addressbook.common;

public class DateComparator {
    //Later will be change will Date class in the project
    public int compare(int date1, int date2) {
        if(date1 < date2)
            return -1;
        else if (date1 == date2)
            return 0;
        else
            return 1;
    }
}
