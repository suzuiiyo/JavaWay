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

        double size = Math.pow(2, 10)*100;   //�ļ�����100K
        //long n=10;   //���÷ָ�����
        File f = new File(path1 + name + end);    //ת�����ļ�����
        File f2;
        byte[] byteArr = new byte[(int)f.length()];
        FileOutputStream out = null;             //���������
        try(InputStream in = new FileInputStream(f)){
            byteArr = InputStreamtoByteArray.read(in);
            int i = 0;
            int len =0;
            for(i=0; i<=(int)(f.length()/size); i++){
                path2 = path1 + name + i + end;
                f2 = new File(path2);
                if(!f2.exists()){
                    f2.createNewFile();
                }
                out = new FileOutputStream(f2);
                len = i*(int)size;              //��¼ÿbyteArrд��f2���byte��λ��
                
                if(i<(int)(f.length()/size)) {  //���ݵ���һ���ֽڣ�����ﵽ����ĩβ�� �򷵻�-1 
                    out.write(byteArr, len, (int)size);   //��byte����д��bye�������
                    //System.out.println("��β�ͣ�" + len);
                }
                else if(i==(int)(f.length()/size)){
                    out.write(byteArr, len, byteArr.length-len);   //��byte����д��bye�������
                    //System.out.println("β�ͣ�" + (byteArr.length-len));
                }
                if(f2.length()>size)
                    break;                  //���ļ�����ָ����С�ʹ�����һ���ļ�;
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
            return;
        }
    }
}
