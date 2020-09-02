package hutubill.util;

import java.util.Date;
import java.util.Calendar;

public class DateUtil2 {
    static long MILLISECONDS_OF_ONEDAY = 1000*60*60*24;

    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }

    //获取今天
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);     //输出的是0：0：0, 24小时制
        //c.set(Calendar.HOUR, 0);          //输出的是12：0：0， 12小时制
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    //获取月初
    public static Date monthBegin(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //把日期设为月初,不写就是today
        c.set(Calendar.DATE, 1);

        c.set(Calendar.HOUR_OF_DAY, 0);  
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    //获取月末
    public static Date monthEnd(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //先取月初
        c.set(Calendar.DATE, 1);
        //然后用roll方法,往前滚动一个月就是月末
        c.roll(Calendar.DATE, -1);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    //获取本月一共多少天
    public static int monthTotalDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(monthEnd());
        return c.get(Calendar.DATE);
    }
    //获取本月还剩多少天
    public static int monthLeftDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(today());
        int end   = monthTotalDay();
        int today = c.get(Calendar.DATE);
        return end - today;
    }

    public static void main(String[] args){
        System.out.println("今天:\t\t" + DateUtil2.today());
        System.out.println("月初:\t\t" + DateUtil2.monthBegin());
        System.out.println("月末:\t\t" + DateUtil2.monthEnd());
        System.out.println("本月总天数:\t" + DateUtil2.monthTotalDay());
        System.out.println("本月剩余天数:\t" + DateUtil2.monthLeftDay());
    }
}