package file;

public class CharToByteArray {
    public static byte[] charToByte(char c){
        byte[] b = new byte[2];
        b[0] = (byte)((c & 0xFF00) >> 8);
        b[1] = (byte)(c & 0xFF);
        return b;
    }
}