package regular;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ForwardPattern{
    public static void main(String[] args) {
        String  reg     = ".+(?=</span>)";
        String  test    = "<span class='read-count'>ÔÄ¶ÁÁ¿: 641</span>";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc      = pattern.matcher(test);
        while(mc.find()){
            System.out.println("Æ¥Åä½á¹û: ");
            System.out.println(mc.group());
        }
    }
}
