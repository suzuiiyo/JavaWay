package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import file.InputStreamtoByteArray;

public class CopyFolder {
    public static void main(String[] args){
        CopyFolder opera = new CopyFolder();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入源文件夹路径: ");
        String strSrc = s.nextLine();
        System.out.println("请输入目的路径: ");
        String strDest = s.nextLine();
        s.close();
        opera.copyFolder(strSrc, strDest);
    }

    public void copyFolder(String strSrc, String strDest){
        File dirSrc = new File(strSrc);
        File[] flist = dirSrc.listFiles();
        String[] fname = dirSrc.list();

        File dirDest = new File(strDest);           //目的目录需要复制文件夹得绝对路径
        if(!dirDest.exists()){
            dirDest.mkdirs();
        }
        
        File[] farr = new File[flist.length];
        for(int i=0; i<flist.length; i++){
            farr[i] = copyObj(flist[i], strDest, fname[i]);
        }
    }

    public File copyObj(File f, String dirDest , String fileName){
        File f2 = new File(dirDest + '/' + fileName);
        /*try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f2))){
            if(!f2.exists()){
                f2.createNewFile();
            }
            oos.writeObject(f);
        }catch(IOException e){
            e.printStackTrace();
        }*/
        try(InputStream is = new FileInputStream(f);
            OutputStream os = new FileOutputStream(f2)){
            if(!f2.exists()){
                f2.createNewFile();
            }
            byte[] bis = InputStreamtoByteArray.read(is);
            os.write(bis);
            }catch(IOException e){
                e.printStackTrace();
            }
        return f2;
    }
}