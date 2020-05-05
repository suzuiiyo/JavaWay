package date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate2 {
    public static void main(String[] args){
        //y  代表年
        //M  代表月
        //d  代表日
        //H  代表24进制的小时
        //h  代表12进制的小时
        //m  代表分钟
        //s   代表秒
        //S   代表毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date d1 = new Date();
        String str = sdf.format(d1);
        System.out.println("当前时间通过yyyy-MM-dd HH:mm:ss SSS格式化候得输出: " +str);
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = new Date();
        String str1 = sdf1.format(d2);
        System.out.println("当前时间通过yyyy-MM-dd格式化后的输出" +  str1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str2 = "2020/5/4 13:43:21";
        try{
            Date d3 = sdf2.parse(str2);
            System.out.printf("字符串%s通过格式yyyy/MM/dd HH:mm:ss %n转换为日期对象：%s", str2, d3.toString());
            }
        catch(ParseException e){
            e.printStackTrace();
            }
    }
}