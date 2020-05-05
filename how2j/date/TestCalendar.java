package date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args){
        //采用单例模式获取日历对象Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss SSS");
        //通过日历对象得到日期对象
        Date d = c.getTime();          //Date.getTime()取得的是一个long型数据，即累计的毫秒数, Calendar.getTime()取得的是一个Date型对象
        Date d2 = new Date(0);           //将d2设为1970年1.1 8时
        c.setTime(d2);                  //将c取得d2的时间原点                                        
        System.out.println("当前时间: " + sdf.format(d));     //把这个日历，调成日期：1970.1.1 08：00：00
        //下个月的今天
        c.setTime(d);            //将时间设为现在
        c.add(Calendar.MONTH, 1);
        Date d3 = c.getTime();
        System.out.println("下个月的今天: " + sdf.format(d3));
        //上个月的今天
        c.setTime(d);
        c.add(Calendar.MONTH, -1);
        Date d4 = c.getTime();
        System.out.println("上个月的今天：" + sdf.format(d4));

        //上个月的第三天
        c.setTime(d);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        Date d5 = c.getTime();
        System.out.println("上个月的第三天: " + sdf.format(d5));
    }
}