package collection;

import java.util.Random;

public class TestHashSet3 {
    public static void main(String[] args) {
        String[] str = new String[1000];
        HashSet<String> strRep = new HashSet<>();
        Random rand = new Random();
        HashSet<String> strSet = new HashSet<>();
        for(String s : str){
            s = String.valueOf((char)(rand.nextInt(122 -30 +1) +30)) + String.valueOf((char)(rand.nextInt(122-30 +1) + 30));
            int len = strSet.size();
            strSet.add(s);
            if(strSet.size() - len == 0)
                strRep.add(s);
            System.out.println(s);
        }
        System.out.println("\n***************\n");
        for(String s2 :strRep){
            System.out.println(s2);
        }
        System.out.println("\n***************\n");
        System.out.println("字符串str中总共有字符串：" + strSet.size()  + "个");
        System.out.println("字符串数组str中重复的字符串总共有: " + strRep.size() + "种");
    }
}