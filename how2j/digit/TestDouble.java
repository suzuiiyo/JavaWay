package digit;

public class TestDouble {
    public static void main(String[] args){
        Double i = 3.14;

        String str = String.valueOf(i);
        System.out.println(str);

        Double str2 = Double.parseDouble(str + "23");
        System.out.println(str2);
    }
}