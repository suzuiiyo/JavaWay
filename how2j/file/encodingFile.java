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
            FileOutputStream fout = new FileOutputStream(f1);   //输出流到f1,写入f1
            char[] ch = new char[95];
            for(int i=0; i<ch.length; i++){
                ch[i] = (char)(rand.nextInt(126-32+1)+32);
            }
            String str = String.valueOf(ch);    //char[]转换成string
            byte[] b = str.getBytes();          //string转换成byte[]以便于outputStream执行write方法
            //fout.write(b, 0, b.length);                         //把byte数组b的内容写到输出流

            byte[] hz = InputStreamtoByteArray.read(in);        //把输入流转换成byte[]
            System.out.println("hz数组的长度： " + hz.length + ", hanzi文件的长度： " + fhz.length());

            byte[] bADDhz = new byte[b.length + hz.length];
            System.arraycopy(b, 0, bADDhz, 0, b.length);
            System.arraycopy(hz, 0, bADDhz, b.length, hz.length);          //将两个文件内容的byte[]合并成一个数组
            fout.write(bADDhz, 0, bADDhz.length);                         //把byte数组b的内容写到输出流
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
            char[] ch = new char[(int)all.length];              //将encoding的内容转换成byte[]
            ch = ByteArrayToCharArray.read(all);               //将byte[]转换成char[]以便和ASCII码进行比较
                                                                //byte[]里面存储的是数字，非汉字是正数，汉字分两个byte储存，第一个是必定负数
            
            for(char c : ch){
                System.out.print(c);
            }

            for(int i=0; i<ch.length; i++){
                byte[] bb = new String(ch).getBytes("UTF-8");     //判断非汉字，汉字的内码在byte[]里面是两个负数
                if(bb[i]>0){
                    if(ch[i]>='0'&&ch[i]<='8')                    //非9数字
                        ch[i] += 1;
                    else if(ch[i] == '9')
                        ch[i] = '0';
                    else if((ch[i]>=65&&ch[i]<90)||(ch[i]>=97&&ch[i]<122))      //大小写字母
                        ch[i] += 1;
                    else if(ch[i] == 'z')
                        ch[i] = 97;
                    else if(ch[i] == 'Z')
                        ch[i] = 65;
                }
            }
            System.out.println("\n\t\t\t\t\t\t*********************************\n");
            for(char c : ch){
                System.out.print(c);
            }
            String bstr = String.valueOf(ch);
            byte[] all2 = bstr.getBytes("UTF-8");
            fout2.write(all2, 0, all2.length);
            fout2.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}