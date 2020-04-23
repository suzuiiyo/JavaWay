package digit;
import java.util.Scanner;

public class TestString2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请分别输入地名、公司类型、公司名称、老板名称、金额、产品和计量单位，以空格隔开");
        String sentence = s.nextLine();
        String[] vals = sentence.split(" ");
        if(vals.length<7||vals.length>7){
            System.out.println("输入的数据格式有误，请重新输入!");
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
        "%s最大互联网%s%s,王八蛋老板%s吃喝嫖赌，欠下%d个亿，带着他的小姨子跑了," +
        "我们没有办法，拿着代码抵押工资，原价都是一%s多、两%s多、三%s多的%s，现在统统只要二十块！%s王八蛋，" +
        "你不是人！我们辛辛苦苦给你干了大半年，你不发工资，你还我血汗钱！还我血汗钱！",
        place, grouptype, groupname, bossname, amount, unit, unit, unit, product, bossname);
    }
}