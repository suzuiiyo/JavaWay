package hutubill.database;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static long millisecondsOfOneDay = 1000*60*60*24;

    //TODO  ��java.util.Date����ת����java.sql.Date����
    public static java.sql.Date util2sql(java.util.Date d){
        //getTime()��ȡ���1970/1/1��ʱ��
        return new java.sql.Date(d.getTime());
    }

    //��ȡ����,���Ұ�ʱ����ͺ��붼����Ϊ0����Ϊͨ�����ڿؼ���ȡ�������ڣ�����û��ʱ����ͺ����
    public static Date today(){
        //Calendar��ȡʵ���õ���getInstance��������new?
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    //��ȡ�³�.ʹ��Calendar��ȡ���µ�һ��,��ͳ������һ����Ϣ��ʱ�򣬲鿴���µ���������,��ʵ���Ǵ����ݿ���ȥ�ɴӱ��µ�һ�쵽���һ������ݲ������
    //�ڽ��м�ͳ�ƣ�������Ҫһ����ȡ���µ�һ��ķ���
    public static Date monthBegin(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
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
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }
    //��ȡ����һ���ж�����
    public static int thisMonthTotalDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();
        return (int) ((lastDayMilliSeconds - firstDayMilliSeconds)/millisecondsOfOneDay) + 1;  //��1��firstDay����
    }
    //��ȡ���»�ʣ������
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) ((lastDayMilliSeconds - toDayMilliSeconds)/millisecondsOfOneDay);  // + 1;  ʣ����������������
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
        System.out.println(DateUtil.thisMonthTotalDay());
        System.out.println(DateUtil.thisMonthLeftDay());
    }
}