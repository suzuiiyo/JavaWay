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
            System.out.printf("����: \"%s�ڱ��뷽ʽ%s�µĺ�����%n", bb, encode);
            //String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
            Charset charset = Charset.forName(encode);              //�û�����decode��������
            ByteBuffer buf = ByteBuffer.wrap(bb);
            CharBuffer charBuffer = charset.decode(buf);       
            String chi = charBuffer.toString();
            System.out.println(chi);
            
            /*String str = new String(bb, "ISO8859-1");        //��String(byte[], Charset)������
            byte[] bb2 = str.getBytes("ISO8859-1");            //��֪��byte[]���뷽ʽ��ǰ���£��ȱ��ISO8859-1����String(byte[], Charset)����
            String str2 = new String(bb2, encode);             //��˵�ǡ�ISO8859-1�����ݱȽϺţ�
            System.out.println();
            System.out.println(str + "   " + str2);*/
        }catch(UnsupportedCharsetException e) {
        //}catch(UnsupportedEncodingException | UnsupportedCharsetException e) {
            System.out.printf("UnsupportedCharsetException: %s���뷽ʽ�޷���������%s\n", encode, bb);
        }
    }
}