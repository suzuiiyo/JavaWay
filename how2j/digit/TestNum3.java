package digit;
import java.util.Scanner;

public class TestNum3 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("������Ӣ�۵�����: ");
        String name = s.nextLine();
        s.close();
        int kill  = 8;
        String title = "����";
        //ֱ��ʹ��+ �����ַ������ӣ�����о���ȽϷ���������ά���Բ�׶��Բ�
        String sentence = name + "�ڽ���������" + kill + "�λ�ɱ�󣬻����" + title + "��ͷ��";

        System.out.println(sentence);

        //ʹ�ø�ʽ�����
        //%s��ʾ�ַ�����%d��ʾ���֣�%n��ʾ����
        String sentenceFormat = "%s�ڽ���������%d�λ�ɱ�󣬻����%s�ĳƺ�%n";
        System.out.printf(sentenceFormat, name, kill, title);
        System.out.format(sentenceFormat, name, kill, title);
    }
}