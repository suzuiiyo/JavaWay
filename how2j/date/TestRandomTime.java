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
            date[i] = year + "��" + month + "��" + day + "��" + hour + "ʱ:" + minute + "��:" + second + "��";
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

        long start = years*year-8*hour;     //�ѵ�ָ�����ʱ�������������ۼ�����,�Ժ���Ϊ��λ
        long randomTime = (long)(Math.random()*year);  //����һ�����ʱ���
        long end = start+randomTime;
        Date d1 = new Date(end);
        System.out.println(d1);
    }
}