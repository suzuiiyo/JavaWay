package file;

import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class encodingFile {
    public static void main(String[] args){
        Random rand = new Random();
        File f1 = new File("d:/Studio/JavaWay/AC/DC/encodingFile.txt");
        File fhz = new File("d:/Studio/JavaWay/AC/DC/hanzi.txt");
        try(InputStream in = new FileInputStream(fhz)){
            if(!f1.exists()){
                f1.createNewFile();
            }
            FileOutputStream fout = new FileOutputStream(f1);   //�������f1,д��f1
            char[] ch = new char[89];
            for(int i=0; i<ch.length; i++){
                ch[i] = (char)(rand.nextInt(90)+33);
            }
            String str = String.valueOf(ch);    //char[]ת����string
            byte[] b = str.getBytes();          //stringת����byte[]�Ա���outputStreamִ��write����
            //fout.write(b, 0, b.length);                         //��byte����b������д�������

            byte[] hz = InputStreamtoByteArray.read(in);        //��������ת����byte[]
            System.out.println("hz����ĳ��ȣ� " + hz.length + ", hanzi�ļ��ĳ��ȣ� " + fhz.length());

            byte[] bADDhz = new byte[b.length + hz.length];
            System.arraycopy(b, 0, bADDhz, 0, b.length);
            System.arraycopy(hz, 0, bADDhz, b.length, hz.length);
            fout.write(bADDhz, 0, bADDhz.length);                         //��byte����b������д�������
            fout.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        File f2 = new File("d:/Studio/JavaWay/AC/DC/encodedFile.txt");
        try(FileInputStream inTwo = new FileInputStream(f1)){
            if(!f2.exists()){
                f2.createNewFile();
            }
            FileOutputStream fout2 = new FileOutputStream(f2);
            byte[] all = InputStreamtoByteArray.read(inTwo);
            char[] ch = new char[(int)all.length];
            for(int i=0; i<all.length; i++){
                if(all[i]<0)
                    ch[i] = (char)(all[i] + 256);
                else
                    ch[i] = (char)all[i];
            }
            for(int i=0; i<=all.length; i++){
                if(ch[i]>='0'&&ch[i]<'9')
                    ch[i] += 1;
                if(ch[i] == '9')
                    ch[i] = 0;
                else if(ch[i]!='z'&&ch[i]!='Z')
                    ch[i] += 1;
                else if(ch[i] == 'z')
                    ch[i] = 97;
                else if(ch[i] == 'Z')
                    ch[i] = 65;
            }
            String bstr = String.valueOf(ch);
            byte[] all2 = bstr.getBytes(bstr);
            fout2.write(all2, 0, all2.length);
            fout2.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}