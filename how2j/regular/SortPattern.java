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
            System.out.println("����ĸ����У�" + mc.groupCount());
            for(int i=0; i<=mc.groupCount(); i++){
                System.out.println("��" + i + "������Ϊ: " + mc.group(i));
            }
        }
    }
}
