package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestOpenException {
    public static void main(String[] args) {
        File f = new File("d:/doat2.exe");
        // ��ͼ���ļ�rainyblue.jpg,���׳�FileNotFoundException,�����������쳣�ᵼ�±������
        try{
            System.out.println("��ͼ��d:/LOL.exe");
            new FileInputStream(f);
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
           // FileInputStream.close();
        }
    }
}
