package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestPrintStream {
    public static void main(String[] args) throws IOException {
        final byte[] arr = { 0x61, 0x62, 0x63, 0x64, 0x65 };
        File file = new File("d:/Studio/JavaWay/AC/DC/printstream.txt");
        PrintStream out;
        try {
            out = new PrintStream(new FileOutputStream(file));
            out.write(arr);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}