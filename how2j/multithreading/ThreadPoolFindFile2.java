package multithreading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolFindFile2 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        String path = "d:/Studio/JavaWay/AC/DC/";
        File f = new File(path);
        List<File> dirFile = new ArrayList<>();                 //用来存储子文件和子文件夹筛选出来的文件

        ThreadPoolFindFile2 tpff = new ThreadPoolFindFile2();
        List<File> flist = tpff.findFileName(f, dirFile);
        Iterator<File> ite = flist.iterator();
        while(ite.hasNext()){
            File fl = ite.next();
            threadPool.execute(new Runnable(){
                public void run(){
                    try {
                        tpff.findFileContents(fl);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public List<File> findFileName(File f, List<File> dirf) {
        File[] fArr = f.listFiles();
        for (int i = 0; i < fArr.length; i++) {
            if(fArr[i].isDirectory()){
                findFileName(fArr[i], dirf);
            }else{
                try (FileReader br = new FileReader(fArr[i])) {
                    if (fArr[i].getName().endsWith(".txt")){
                        dirf.add(fArr[i]);
                        System.out.println("筛选出来的文件: " + fArr[i].getName());
                    }
                }
                catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
        return dirf;
    }

    public void findFileContents(File fl) throws FileNotFoundException {
        try(FileReader fr = new FileReader(fl)){
            char[] fCh = new char[100];
            fr.read(fCh);
            if(String.valueOf(fCh).contains("狼牙")){
                System.out.println("包含匹配内容的文件: " + fl.getName());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}