package date;
import java.util.Date;

public class TestDate {
    public static void main(String[] args){
        Date now = new Date();
        //��ӡ��ǰʱ��
        System.out.println("��ǰʱ�䣺" + now.toString());
        //getTime()�õ�һ��long�͵�����
        System.out.println("��ǰʱ��Date.getTime()���ص�ֵ��: " + now.getTime());
        System.out.println("��ǰʱ��System.currentTimeMillis()���ص�ֵ��: " + System.currentTimeMillis());

        Date zero = new Date(0);
        System.out.println("��0��Ϊ�������,�õ��������ǣ�" + zero);
    }
}