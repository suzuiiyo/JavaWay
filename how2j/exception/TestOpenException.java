package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestOpenException {
    public static void main(String[] args) {
        File f = new File("d:/doat2.exe"); 
        InputStream in = null;
        // ��ͼ���ļ�rainyblue.jpg,���׳�FileNotFoundException,�����������쳣�ᵼ�±������
        try{
            System.out.println("��ͼ��d:/LOL.exe");
            in = new FileInputStream(f);
            System.out.println("�ɹ���");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2016-06-03");
        } 
        /*catch (FileNotFoundException e) {
            System.out.println("d:/data2������");
            e.printStackTrace();
        }
        catch(ParseException e){
            System.out.println("���ڸ�ʽ��������ȷ");
            e.printStackTrace();
        }*/
        catch(FileNotFoundException | ParseException e){
            if(e instanceof FileNotFoundException){
                System.out.println("�Ҳ����ļ�");
            }
            if(e instanceof ParseException){
                System.out.println("���ڸ�ʽ��������");
            }
            e.printStackTrace();
        }
        finally{
            //��finally��ر���
            if(null != in){
                try{
                    in.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
