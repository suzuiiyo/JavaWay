package multithreading;

import java.util.ArrayList;
import java.util.List;

public class EnumCrackThread3 {
    public static boolean found = false;
    public static void main(String[] args){
        String password = randomString(3);
        System.out.println("生成的密码是: "  + password);
        List<String> passwords = new ArrayList<>();

        new CrackPasswdThread3(password, passwords).start();
        System.out.println("总共尝试了: " + passwords.size() + "次");
        new CrackDiaryThread3(passwords).start();
    }

    private static String randomString(int length){
        String pool = "";
        for(short i='0'; i<='9'; i++){
            pool += (char) i;
        }
        for(short i='a'; i<='z'; i++){
            pool += (char) i;
        }
        for(short i = 'A'; i< 'Z'; i++){
            pool += (char) i;
        }
        char cs[] = new char[length];
        for(int i=0; i<cs.length; i++){
            int index =(int)(Math.random()*pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
}