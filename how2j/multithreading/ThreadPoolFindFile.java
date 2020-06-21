package multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreadPoolFindFile {
    public static void main(String[] args) {
        String path = "d:/Studio/JavaWay/AC/DC/";
        File f = new File(path);
        List<File> dirFile = new ArrayList<>();                 //用来存储子文件和子文件夹筛选出来的文件
        ThreadPoolFindFile tpff = new ThreadPoolFindFile();
        //List<File> flist = new ArrayList<>();
        //flist = tpff.findFileName(f, dirFile);                 //将返回的dirFile赋值给flist
        try {
            tpff.findFileContents(tpff.findFileName(f, dirFile));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("\n*******************\n");
        for(File h : dirFile){
            System.out.println(h);
        }
    }

    public List<File> findFileName(File f, List<File> dirf) {
        File[] fArr = f.listFiles();
        for (int i = 0; i < fArr.length; i++) {
            if(fArr[i].isDirectory()){
                findFileName(fArr[i], dirf);
            }else{
                try (FileReader br = new FileReader(fArr[i])) {
                    if (fArr[i].getName().endsWith("txt"))
                        dirf.add(fArr[i]);
                        System.out.println("筛选出来的文件: " + fArr[i].getName());
                    }
                catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
        return dirf;
    }

    public void findFileContents(List<File> fl) throws FileNotFoundException {
        for(File f : fl){
            try(FileReader fr = new FileReader(f)){
                char[] fCh = new char[100];
                fr.read(fCh);
                if(String.valueOf(fCh).contains("狼牙")){
                    System.out.println("包含匹配内容的文件: " + f.getName());
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}