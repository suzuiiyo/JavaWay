package digit;

public class TestString4 {
    public static void main(String[] args){
        String name = "����";
        int kill = 8;
        String title = "����";

        String sentence = name + "����������" + kill + "�λ�ɱ�󣬻����" + title + "�ĳƺ�";
        System.out.println(sentence);

        String sentenceFormat = "%s�ڽ���������%d�λ�ɱ�󣬻����%s�ĳƺ�%n";
        String sentence2 = String.format(sentenceFormat, name, kill, title);
        System.out.println(sentence2);
    }
}