package regular;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class backwardPattern {
    public static void main(String[] args) {
        String  reg     = "\\d+(?=</span>)";
        String  test    = "<span class='read-count'>ÔÄ¶ÁÊı: 641</span>";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc      = pattern.matcher(test);
        while(mc.find()){
            System.out.println(mc.group());
        }
    }
}
