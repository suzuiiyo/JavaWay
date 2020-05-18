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
                int typeHigh = byUTF[i]&0xf0;                               //ȡÿ���ֽڵĸ�4λ
                if(Integer.toHexString(typeHigh).equals("e0")){             //��Ϊ����UTF-8����ĵ�һ���ֽڵĸ���λ�ض���E
                    count = i-1;                                            //�ж��ַ���������ͬ��str1.equals(str2)����
                    break;
                }
            }
            System.out.println("�ļ�f�ڵĺ��ֵı���Ϊ: ");
            for(int j = 0; j<byUTF.length; j++){
                int type = byUTF[j]&0xff;                                   //��ÿ���ֽ�ȡ����
                System.out.print(Integer.toHexString(type) + " ");          //��ʮ�����ƽ����ֱ����ӡ����
            }
            System.out.println();
            System.out.println("\n **************************************** \n");
            System.out.println("�����ܳ���: " + byUTF.length);
            if(count > 0){                                                  //�����BOM�� count�ش���0
                System.out.println(Integer.toHexString(byUTF[count]&0xff));
                System.out.println("BOM����: " + count);
            }else{
                System.out.println("û��BOM");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}