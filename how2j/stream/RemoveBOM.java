package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import file.InputStreamtoByteArray;

public class RemoveBOM {
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/BOM.txt");
        try(InputStream in = new FileInputStream(f)){
            byte[] byUTF = new byte[(int)f.length()];
            byUTF = InputStreamtoByteArray.read(in);
            String str = new String(byUTF, "GBK");
            String str2 = new String(byUTF, "UTF-8");
            System.out.println(str + "      " + str2);
            System.out.println("\n **************************************** \n");

            int count = 0;
            for(int i=0; i<byUTF.length; i++){
                int typeHigh = byUTF[i]&0xf0;                               //取每个字节的高4位
                if(Integer.toHexString(typeHigh).equals("e0")){             //因为汉字UTF-8编码的第一个字节的高四位必定是E
                    count = i-1;                                            //判断字符串内容相同用str1.equals(str2)方法
                    break;
                }
            }
            System.out.println("文件f内的汉字的编码为: ");
            for(int j = 0; j<byUTF.length; j++){
                int type = byUTF[j]&0xff;                                   //把每个字节取出来
                System.out.print(Integer.toHexString(type) + " ");          //以十六进制将汉字编码打印出来
            }
            System.out.println();
            System.out.println("\n **************************************** \n");
            System.out.println("编码总长度: " + byUTF.length);
            if(count > 0){                                                  //如果有BOM， count必大于0
                System.out.println(Integer.toHexString(byUTF[count]&0xff));
                System.out.println("BOM长度: " + count);
            }else{
                System.out.println("没有BOM");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}