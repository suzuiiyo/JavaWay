package digit;

public class TestString7 {
    public static void main(String[] args){
        String str1 = "let there";
        StringBuffer sb = new StringBuffer(str1);  //����str1����һ��StringBuffer����
        sb.append("be right");  //�����׷��

        System.out.println(sb);
        sb.delete(4, 10);   //ɾ��4-10֮����ַ�
        System.out.println(sb);
        sb.insert(4, "there");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}