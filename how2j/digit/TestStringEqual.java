package digit;

public class TestStringEqual {
    public static void main(String[] args){
        String str1 = "God said there should be light, then light there be.";
        String str2 = new String(str1);
        String str7 = str1;

        //==�����ж��Ƿ���ͬһ���ַ�������
        System.out.println(str1 == str2);
        System.out.println(str1 == str7);


        int str3 = 777;
        int str4 = str3;
        //==�����ж��Ƿ���ͬһ���ַ�������
        System.out.println(str3 == str4);

        char str5 = 'a';
        char str6 = str5;
        //==�����ж��Ƿ���ͬһ���ַ�������
        System.out.println(str3 == str6);
    }
}