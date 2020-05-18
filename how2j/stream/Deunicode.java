package stream;

import java.io.UnsupportedEncodingException;

public class Deunicode {

    /**
*?将?16?进制字符串转换成汉字
*/
    public static void main(String[] args){
        String str = "6C49";
        String hanzi = deUnicode(str);
        System.out.printf("对应的汉字是%s:", hanzi);
    }

    public static String deUnicode(String str) {
        byte[] bytes = new byte[str.length() / 2];
        byte tempByte = 0;
        byte tempHigh = 0;
        byte tempLow = 0;
        for (int i = 0, j = 0; i < str.length(); i += 2, j++) {
            //System.out.println((int)str.charAt(i));    //返回的是索引为i的元素的(ASCII码)
            tempByte = (byte) (((int) str.charAt(i)) & 0xff);
            if (tempByte >= 48 && tempByte <= 57) {
                tempHigh = (byte) ((tempByte - 48) << 4);       //取高四位
            } else if (tempByte >= 97 && tempByte <= 101) {
                tempHigh = (byte) ((tempByte - 97 + 10) << 4);
            }
            tempByte = (byte) (((int) str.charAt(i + 1)) & 0xff);
            if (tempByte >= 48 && tempByte <= 57) {             
                tempLow = (byte) (tempByte - 48);               //取低四位
            } else if (tempByte >= 97 && tempByte <= 101) {
                tempLow = (byte) (tempByte - 97 + 10);
            }
            bytes[j] = (byte) (tempHigh | tempLow);             
        }
        String result = null;
        try {
            result = new String(bytes, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}