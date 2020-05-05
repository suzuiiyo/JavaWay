package date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args){
        //���õ���ģʽ��ȡ��������Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss SSS");
        //ͨ����������õ����ڶ���
        Date d = c.getTime();          //Date.getTime()ȡ�õ���һ��long�����ݣ����ۼƵĺ�����, Calendar.getTime()ȡ�õ���һ��Date�Ͷ���
        Date d2 = new Date(0);           //��d2��Ϊ1970��1.1 8ʱ
        c.setTime(d2);                  //��cȡ��d2��ʱ��ԭ��                                        
        System.out.println("��ǰʱ��: " + sdf.format(d));     //������������������ڣ�1970.1.1 08��00��00
        //�¸��µĽ���
        c.setTime(d);            //��ʱ����Ϊ����
        c.add(Calendar.MONTH, 1);
        Date d3 = c.getTime();
        System.out.println("�¸��µĽ���: " + sdf.format(d3));
        //�ϸ��µĽ���
        c.setTime(d);
        c.add(Calendar.MONTH, -1);
        Date d4 = c.getTime();
        System.out.println("�ϸ��µĽ��죺" + sdf.format(d4));

        //�ϸ��µĵ�����
        c.setTime(d);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DATE, 3);
        Date d5 = c.getTime();
        System.out.println("�ϸ��µĵ�����: " + sdf.format(d5));
    }
}