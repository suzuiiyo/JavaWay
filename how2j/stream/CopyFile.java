package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args){
        CopyFile ff = new CopyFile(); 
        String str1 = "d:/Studio/JavaWay/AC/DC/";
        File fdir = new File(str1);
        String[] strf = fdir.list();
        int len = strf.length;
        System.out.println("��ʼ��������,�밴ָʾ����");
        ff.copyFile(str1);
        String[] strf2 = fdir.list();
        int len2 = strf2.length;
        if(len2 - len == 1){
            System.out.println("���������ɹ�!");
        }
    }

    public void copyFile(String str1){
        Scanner s = new Scanner(System.in);
        System.out.println("�����뱻���Ƶ��ļ�����: ");
        String str2 = s.nextLine();
        s.close();
        File f = new File(str1 + str2);
        String str3 = str1 + "����" + str2;
        File f1 = new File(str3);
        try(BufferedReader bfr = new BufferedReader(new FileReader(f));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(f1))){
            if(!f1.exists()){
                f1.createNewFile();
            }
            while(true){
                String line = bfr.readLine();
                if(null != line){
                    if(line.equals("")){                //��⵽�հ���
                        bfw.write("\n\n");
                    }else{
                        bfw.write(line);
                        bfw.flush();
                    }
                }else if(null == line){
                    break;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}