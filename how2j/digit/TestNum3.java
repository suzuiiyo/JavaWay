package digit;
import java.util.Scanner;

public class TestNum3 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入英雄的名称: ");
        String name = s.nextLine();
        s.close();
        int kill  = 8;
        String title = "超神";
        //直接使用+ 进行字符串连接，编码感觉会比较繁琐，并且维护性差，易读性差
        String sentence = name + "在进行了连续" + kill + "次击杀后，获得了" + title + "的头衔";

        System.out.println(sentence);

        //使用格式化输出
        //%s表示字符串，%d表示数字，%n表示换行
        String sentenceFormat = "%s在进行了连续%d次击杀后，获得了%s的称号%n";
        System.out.printf(sentenceFormat, name, kill, title);
        System.out.format(sentenceFormat, name, kill, title);
    }
}