package file;

public class ForceDecode {
    public static void main(String[] args) throws Exception {
        String str = "Ìì";
        byte[] b = str.getBytes("GBK");
        show(b);
        String str2 = new String(b, "ISO8859-1");
        byte[] b2 = str2.getBytes("ISO8859-1");
        show(b2);
        System.out.println(new String(b2, "GBK"));
    }

    public static void show(byte[] b) {
        for(byte by : b ){
            System.out.print(by + " ");
        }
        System.out.println();
    }
}