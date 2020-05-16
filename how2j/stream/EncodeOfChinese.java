package stream;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class EncodeOfChinese {
    public static void main(String[] args){
        byte[] bb = {(byte)0xA2, (byte)0xB9, (byte)0x9C}; 
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
            System.out.printf("����: \"%s�ڱ��뷽ʽ%s�µĺ�����%n", bb, encode);
            //String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
            Charset charset = Charset.forName(encode);
            ByteBuffer buf = ByteBuffer.wrap(bb);
            CharBuffer charBuffer = charset.decode(buf);
            String chi = charBuffer.toString();
            System.out.println();
            System.out.println(chi);
        }catch(UnsupportedCharsetException e) {
            System.out.printf("UnsupportedCharsetException: %s���뷽ʽ�޷���������%s\n", encode, bb);
        }
    }
}