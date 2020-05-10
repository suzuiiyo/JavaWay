package file;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TestSplitFile {
    public static void main(String[] args){
        String path1 = "d:";
        String name = "\\Studio\\JavaWay\\AC\\DC\\scared";
        String end = ".gif";
        String path2;

        double l = Math.pow(2, 10)*100;   //�ļ�����
        //long n=10;   //���÷ָ�����
        File f = new File(path1 + name + end);    //ת�����ļ�����
        File f2;
        InputStream in = null;              //�����ֽ���
        PrintStream out = null;             //������ӡ��
        try{
            in = new FileInputStream(f);    //���ļ�fת�����ֽ�������
            int tempbyte;                   //�ֽ�������ֵ,Ϊ-1ʱ�ֽ�������
            int i = 0;
            for(i=0; i<=(int)(f.length()/l); i++){
                path2 = path1 + name + i + end;
                f2 = new File(path2);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                out = new PrintStream(f2);
                
                while((tempbyte = in.read()) != -1){   //���ݵ���һ���ֽڣ�����ﵽ����ĩβ�� �򷵻�-1 
                    out.println((char)tempbyte);   //��ӡ��ʲô��
                    System.out.write(tempbyte);
                    if(f2.length()>l)
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