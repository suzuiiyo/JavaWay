package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecodeFile {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/decodeFile.txt");
        File fin = new File("d:/Studio/JavaWay/AC/DC/encodedFile.txt");

        try(InputStream in = new FileInputStream(fin)){
            if(!f.exists()){
                f.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(f);
            byte[] bb = InputStreamtoByteArray.read(in);
            char[] ch = ByteArrayToCharArray.read(bb);

            for(char c : ch){
                System.out.print(c);
            }

            for(int i=0; i<ch.length; i++){
                if(bb[i]>0){
                    if(ch[i]>'0'&&ch[i]<='9')                    //非9数字
                        ch[i] -= 1;
                    else if(ch[i] == '0')
                        ch[i] = '9';
                    else if((ch[i]>65&&ch[i]<=90)||(ch[i]>97&&ch[i]<=122))      //大小写字母
                        ch[i] -= 1;
                    else if(ch[i] == 'a')
                        ch[i] = 122;
                    else if(ch[i] == 'A')
                        ch[i] = 90;
                }
            }
            System.out.println("\n\t\t\t\t\t\t********************************");
            for(char c : ch){
                System.out.print(c);
            }
            String bstr = String.valueOf(ch);
            byte[] bbout = bstr.getBytes("UTF-8");
            fout.write(bbout);
            fout.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}