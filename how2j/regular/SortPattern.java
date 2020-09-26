package regular;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SortPattern {
    public static void main(String[] args) {
        String test = "020-85653333";
        String reg="(0\\d{2})-(\\d{8})";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(test);
        if(mc.find()){
            System.out.println("分组的个数有：" + mc.groupCount());
            for(int i=0; i<=mc.groupCount(); i++){
                System.out.println("第" + i + "个分组为: " + mc.group(i));
            }
        }
    }
}
