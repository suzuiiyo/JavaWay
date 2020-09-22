package digit;
import java.util.Random;

public class TestPerformance {
    public static void main(String[] args){
        Random rand = new Random();
        char[] ch = new char[10];
        for(int i=0; i<ch.length; i++){
            ch[i] = (char) (rand.nextInt('z' - 'A'));
        }
        String str = String.valueOf(ch);
        long t1=System.currentTimeMillis();
        for(int j=0; j<10000; j++)
            str+=(char)(rand.nextInt('z'-'A')+'A');
        double t2 = System.currentTimeMillis();
        System.out.printf("String???¡À??%.2f\n", t2-t1);
        //System.out.println(str);

        StringBuffer str1 = new StringBuffer(str);
        long t3=System.currentTimeMillis();
        for(int j=0; j<10000; j++)
            str1.append((char)(rand.nextInt('z'-'A')+'A'));
        double t4 = System.currentTimeMillis();
        System.out.printf("StringBuffer???¡À??%.2f\n", t4 - t3);
//        System.out.println(str1);
        
        MyStringBuffer str2 = new MyStringBuffer(str);
        double t5=System.currentTimeMillis();
        for(int j=0; j<10000; j++)
            str2.append((char)(Math.random()*10000));
        double t6 = System.currentTimeMillis();
        System.out.printf("MyStringBuffer???¡À: %.2f\n", t6-t5);
    }
}