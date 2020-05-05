package date;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormat {
    public static void main(String[] args){
        long second = 1000;
        long minute = second*60;
        long hour = minute*60;
        long day = hour*24;
        long year = 365*day -1;
        long years = 2000 -1970;
        long[] randomTime = new long[9];
        Date[] d = new Date[9];
        Calendar cal = Calendar.getInstance();
        int[] Month = new int[9];
        int[] Day = new int[9];
        for (int i =0; i<d.length; i++){
            randomTime[i] = (long)(Math.random()*year*years);   //生成日期数组
            d[i] = new Date(0+randomTime[i]);
            cal.setTime(d[i]);
            Month[i] = cal.get(Calendar.MONTH)+1;
            Day[i] = cal.get(Calendar.DATE);
            System.out.println(Month[i] + "/" + Day[i] + "       " + d[i]);
        }
        System.out.println("***********************************");
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        int[] MM = new int[9];
        int[] dd = new int[9];
        for(int i=0; i<d.length; i++){
            MM[i] = Integer.parseInt(sdf.format(d[i]));
            dd[i] = Integer.parseInt(sdf1.format(d[i]));
            System.out.println(MM[i] + "/" + dd[i] + "      " + d[i]);     //为社么？？？？
            for(int j=0; j<d.length-i-1; j++){
                if(MM[j]>MM[j+1]){
                    Date temp = d[j];
                    d[j] = d[j+1];
                    d[j+1] = temp;
                }else if(MM[j]==MM[j+1]&&dd[j]>dd[j+1]){
                    Date temp = d[j];
                    d[j] = d[j+1];
                    d[j+1] = temp;
                }
            }
        }
        for(Date each : d){
            System.out.println(each);
        }
    }
}