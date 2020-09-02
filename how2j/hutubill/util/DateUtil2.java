package hutubill.util;

import java.util.Date;
import java.util.Calendar;

public class DateUtil2 {
    static long MILLISECONDS_OF_ONEDAY = 1000*60*60*24;

    public static java.sql.Date util2sql(java.util.Date d){
        return new java.sql.Date(d.getTime());
    }

    //��ȡ����
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);     //�������0��0��0, 24Сʱ��
        //c.set(Calendar.HOUR, 0);          //�������12��0��0�� 12Сʱ��
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    //��ȡ�³�
    public static Date monthBegin(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //��������Ϊ�³�,��д����today
        c.set(Calendar.DATE, 1);

        c.set(Calendar.HOUR_OF_DAY, 0);  
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    //��ȡ��ĩ
    public static Date monthEnd(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        //��ȡ�³�
        c.set(Calendar.DATE, 1);
        //Ȼ����roll����,��ǰ����һ���¾�����ĩ
        c.roll(Calendar.DATE, -1);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    //��ȡ����һ��������
    public static int monthTotalDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(monthEnd());
        return c.get(Calendar.DATE);
    }
    //��ȡ���»�ʣ������
    public static int monthLeftDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(today());
        int end   = monthTotalDay();
        int today = c.get(Calendar.DATE);
        return end - today;
    }

    public static void main(String[] args){
        System.out.println("����:\t\t" + DateUtil2.today());
        System.out.println("�³�:\t\t" + DateUtil2.monthBegin());
        System.out.println("��ĩ:\t\t" + DateUtil2.monthEnd());
        System.out.println("����������:\t" + DateUtil2.monthTotalDay());
        System.out.println("����ʣ������:\t" + DateUtil2.monthLeftDay());
    }
}