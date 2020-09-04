package hutool;

import cn.hutool.core.util.HexUtil;

public class TestHex2 {
    public static void main(String[] args) {
        String s1 = "12";
        boolean b1 = HexUtil.isHexNumber(s1);
        String s2 = "0x12";
        boolean b2 = HexUtil.isHexNumber(s2);

        System.out.println(b1);
        System.out.println(b2);
    }
}
