package digit;

public class TestString4 {
    public static void main(String[] args){
        String name = "剑姬";
        int kill = 8;
        String title = "超神";

        String sentence = name + "进行了连续" + kill + "次击杀后，获得了" + title + "的称号";
        System.out.println(sentence);

        String sentenceFormat = "%s在进行了连续%d次击杀后，获得了%s的称号%n";
        String sentence2 = String.format(sentenceFormat, name, kill, title);
        System.out.println(sentence2);
    }
}