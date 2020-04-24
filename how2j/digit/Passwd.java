package digit;
import java.util.Random;

public class Passwd {

    public static void main(String[] args){
        //Random rand = new Random();
        char[] pass = new char[3];
        for(int i=0; i<pass.length; i++){
            pass[i] = (char)(rand.nextInt(58) + 65);
        }
        String str = String.valueOf(pass);
        System.out.println(str);

        /*char[] gen = new char[3];
        boolean flag = true;
        for (int i = 0; i < 1000; i++) { // Ñ­»·ÅÐ¶Ï
            gen[0] = (char) (rand.nextInt(90) + 33);
            if (gen[0] == pass[0] && flag) {
                for (int j = 0; j < 1000; j++) {
                    gen[1] = (char) (rand.nextInt(90) + 33);
                    if (gen[1] == pass[1] && flag) {
                        for (int k = 0; k < 1000; k++) {
                            gen[2] = (char) (rand.nextInt(90) + 33);
                            if (gen[2] == pass[2] && flag) {
                                String str2 = String.valueOf(gen);
                                flag = false;
                                System.out.println(str + "=" + str2);
                            }
                        }
                    }
                }
            }
        }*/

        // µÝ¹éÅÐ¶Ï
        Passwd key = new Passwd();
        key.arr1 = pass; // µ÷ÓÃarr1´æÈë³õÊ¼ÃÜÂëpassÊý×é
        char pass2[] = new char[3];
        key.arr2 = pass2;
        for(int i=0; ; i++){
            key.judgeKey(key.judgeKey(Passwd.count));
            System.out.print(Passwd.count + " ");
            if(Passwd.count==2)
                break;
        }
        String str3 = String.valueOf(pass2);
        System.out.println("count:" + Passwd.count);
        System.out.println(str + "=" + str3);
    }

    static Random rand = new Random();
    private char[] arr1;
    private char[] arr2;
    static int count;
    //µÝ¹éÅÐ¶Ï
    public int judgeKey(int count){
        arr2[count] = (char)(rand.nextInt(58)+65);
        //System.out.print(arr2[count] + " ");
        if(arr1[count]==arr2[count]){
            count++;
        }
        //System.out.print(count + " ");
        return count;
    }
}