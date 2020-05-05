package date;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WhichDay {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = "2016-06-01 17:22:00 654";
        Calendar c = Calendar.getInstance();
        try{
            Date d1 = sdf.parse(now);
            c.setTime(d1);
            c.add(Calendar.MONTH, 2);
            c.set(Calendar.DATE, -2) ;
            Date d2 = c.getTime();
            System.out.println("现在是：" + now + ", 下个月的倒数第三天是: " + sdf.format(d2));
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }
}