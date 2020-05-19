package stream;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class EncodeOfChinese {
    public static void main(String[] args){
        byte[] bb = {(byte)0xE5, (byte)0xB1, (byte)0x8A}; 
        showChinese(bb);
    }

    private static void showChinese(byte[] bb){
        String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
        for(String encode : encodes){
            showChinese(bb, encode);
        }
    }

    private static void showChinese(byte[] bb,  String encode){
        try{
            System.out.printf("编码: \"%s在编码方式%s下的汉字是%n", bb, encode);
            //String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
            Charset charset = Charset.forName(encode);              //用缓存块的decode方法解码
            ByteBuffer buf = ByteBuffer.wrap(bb);
            CharBuffer charBuffer = charset.decode(buf);       
            String chi = charBuffer.toString();
            System.out.println(chi);
            
            /*String str = new String(bb, "ISO8859-1");        //用String(byte[], Charset)来解码
            byte[] bb2 = str.getBytes("ISO8859-1");            //不知道byte[]编码方式的前提下，先变成ISO8859-1再用String(byte[], Charset)解码
            String str2 = new String(bb2, encode);             //据说是“ISO8859-1”兼容比较号？
            System.out.println();
            System.out.println(str + "   " + str2);*/
        }catch(UnsupportedCharsetException e) {
        //}catch(UnsupportedEncodingException | UnsupportedCharsetException e) {
            System.out.printf("UnsupportedCharsetException: %s编码方式无法解析编码%s\n", encode, bb);
        }
    }
}