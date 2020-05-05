package date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate2 {
    public static void main(String[] args){
        //y  ������
        //M  ������
        //d  ������
        //H  ����24���Ƶ�Сʱ
        //h  ����12���Ƶ�Сʱ
        //m  �������
        //s   ������
        //S   �������
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date d1 = new Date();
        String str = sdf.format(d1);
        System.out.println("��ǰʱ��ͨ��yyyy-MM-dd HH:mm:ss SSS��ʽ��������: " +str);
        
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = new Date();
        String str1 = sdf1.format(d2);
        System.out.println("��ǰʱ��ͨ��yyyy-MM-dd��ʽ��������" +  str1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str2 = "2020/5/4 13:43:21";
        try{
            Date d3 = sdf2.parse(str2);
            System.out.printf("�ַ���%sͨ����ʽyyyy/MM/dd HH:mm:ss %nת��Ϊ���ڶ���%s", str2, d3.toString());
            }
        catch(ParseException e){
            e.printStackTrace();
            }
    }
}