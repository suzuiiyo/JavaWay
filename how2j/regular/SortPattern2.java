package regular;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SortPattern2 {
    public static void main(String[] args) {
        String test = "020-85653333";
        String reg = "(?<quhao>0\\d{2})-(?<haoma>\\d{8})";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(test);
        if(mc.find()){
            System.out.println("分组的个数有: " + mc.groupCount());
            System.out.println(mc.group("quhao"));
            System.out.println(mc.group("haoma"));
        }
    }
}
