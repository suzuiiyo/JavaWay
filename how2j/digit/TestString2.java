package digit;
import java.util.Scanner;

public class TestString2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("��ֱ������������˾���͡���˾���ơ��ϰ����ơ�����Ʒ�ͼ�����λ���Կո����");
        String sentence = s.nextLine();
        String[] vals = sentence.split(" ");
        if(vals.length<7||vals.length>7){
            System.out.println("��������ݸ�ʽ��������������!");
            return;
        }
        s.close();

        System.out.println("/n");
        String place = vals[0];
        String grouptype = vals[1];
        String groupname = vals[2];
        String bossname = vals[3];
        int amount = Integer.parseInt(vals[4]);
        String product = vals[5];
        String unit = vals[6];

        System.out.format(
        "%s�������%s%s,���˵��ϰ�%s�Ժ��ζģ�Ƿ��%d���ڣ���������С��������," +
        "����û�а취�����Ŵ����Ѻ���ʣ�ԭ�۶���һ%s�ࡢ��%s�ࡢ��%s���%s������ͳͳֻҪ��ʮ�飡%s���˵���" +
        "�㲻���ˣ�����������������˴���꣬�㲻�����ʣ��㻹��Ѫ��Ǯ������Ѫ��Ǯ��",
        place, grouptype, groupname, bossname, amount, unit, unit, unit, product, bossname);
    }
}