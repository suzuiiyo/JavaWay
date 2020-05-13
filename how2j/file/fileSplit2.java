package file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileSplit2 {
    public static void main(String[] args){
        String dirHead = "d:Studio/JavaWay/AC/DC/";
        String name = "scared";
        String dirTail = ".gif";
        double size = Math.pow(2, 10)*100;
        File f = new File(dirHead + name + dirTail);
        //InputStream in = null;
        FileOutputStream fout = null;
        byte[] byteArr = new byte[(int)Math.pow(2, 20)*2];
        try(InputStream in = new FileInputStream(f)){
            int tempbyte;
            byteArr = InputStreamtoByteArray.read(in);
            for(int i=0; i<f.length()/size; i++){
                File f2 = new File(dirHead + name + i + dirTail);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                fout = new FileOutputStream(f2);
                while((tempbyte = in.read()) != -1){
                    fout.write(byteArr);
                    System.out.write(tempbyte);
                    if(f2.length() > size)
                        break;
                }
            }
            //fout.flush();
            fout.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}