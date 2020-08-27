package hutubill.database;

import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        c.set(2001, 0, 30);
        c.set(Calendar.MONTH, 13);
        System.out.println(c.getTime().toString());
        c.set(2001, 0, 30);
        c.add(Calendar.MONTH, 13);
        System.out.println(c.getTime().toString());
        c.set(2001, 0, 30);
        c.roll(Calendar.MONTH, 13);
        System.out.println(c.getTime().toString());
    }
}