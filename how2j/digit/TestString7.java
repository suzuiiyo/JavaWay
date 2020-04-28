package digit;

public class TestString7 {
    public static void main(String[] args){
        String str1 = "let there";
        StringBuffer sb = new StringBuffer(str1);  //根据str1创建一个StringBuffer对象
        sb.append("be right");  //在最后追加

        System.out.println(sb);
        sb.delete(4, 10);   //删除4-10之间的字符
        System.out.println(sb);
        sb.insert(4, "there");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}