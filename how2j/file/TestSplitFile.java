package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintStream;

public class TestSplitFile {
    public static void main(String[] args){
        String path1 = "d:";
        String name = "\\Studio\\JavaWay\\AC\\DC\\scared";
        String end = ".gif";
        String path2;

        double size = Math.pow(2, 10)*100;   //�ļ�����
        //long n=10;   //���÷ָ�����
        File f = new File(path1 + name + end);    //ת�����ļ�����
        File f2;
        byte[] byteArr = new byte[(int)f.length()];
        InputStream in = null;              //����������
        FileOutputStream out = null;             //���������
        try{
            in = new FileInputStream(f);    //���ļ�fת�����ֽ�������
            int tempbyte;                   //�ֽ�������ֵ,Ϊ-1ʱ�ֽ�������
            int i = 0;
            int count =0;
            for(i=0; i<=(int)(f.length()/size); i++){
                path2 = path1 + name + i + end;
                f2 = new File(path2);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                out = new FileOutputStream(f2);
                count = i*(int)size;
                
                while((tempbyte = in.read()) != -1){
                    if(i<18) {  //���ݵ���һ���ֽڣ�����ﵽ����ĩβ�� �򷵻�-1 
                        out.write(byteArr, count, (int)size-1);   //��byte����д��bye�������
                        System.out.write(tempbyte);
                    }
                    else if(i==18){
                        out.write(byteArr, count, byteArr.length-count);   //��byte����д��bye�������
                        System.out.write(tempbyte);
                    }
                    if(f2.length()>size)
                        break;                  //���ļ�����ָ����С�ʹ�����һ���ļ�;
                }
            }
            out.flush();
            out.close();
            in.close();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
    }
}