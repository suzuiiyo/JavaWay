package date;
import java.util.Random;
import java.util.Date;

public class TestRandomTime {
    /*static Random rand = new Random();

    public static void main(String[] args) {
        String[] date = new String[365];
        for(int i=0; i<date.length; i++){
            String second = String.valueOf(rand.nextInt(60) + 1);
            String minute = String.valueOf(rand.nextInt(60) + 1);
            String hour = String.valueOf(rand.nextInt(12) + 1);
            String day = String.valueOf(rand.nextInt(31) + 1);
            String month = String.valueOf(rand.nextInt(12) + 1);
            String year = new String("1995");
            date[i] = year + "年" + month + "月" + day + "日" + hour + "时:" + minute + "分:" + second + "秒";
            System.out.println(date[i]);
        }
    }*/
    
    public static void main(String[] args){
        long second = 1000;
        long minute = 60*second;
        long hour = 60*minute;
        long day = 24*hour;
        //long month = 30*day;
        //long year = 12*month+4;
        long year = 365*day-1;
        long years = 1995-1970;

        long start = years*year-8*hour;     //把到指定年份时间点的所有秒数累计起来,以毫秒为单位
        long randomTime = (long)(Math.random()*year);  //增加一个随机时间段
        long end = start+randomTime;
        Date d1 = new Date(end);
        System.out.println(d1);
    }
}