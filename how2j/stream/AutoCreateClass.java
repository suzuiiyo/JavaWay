package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AutoCreateClass {
    static String className = "";
    public static void main(String[] args){
        File f = new File("d:/Studio/JavaWay/AC/DC/AutoClass.java");
        System.out.println("加载模板文件..");
        String[] s1 = loadFile(f);
        for(String s :  s1){
            System.out.println(s);
        }
        System.out.println("模板加载完成， 开始处理");
        s1 = replaceInput(s1);
        System.out.println("文件替换后的内容: ");
        for(String s : s1){
            System.out.println(s);
        }
        System.out.println("开始创建文件.. ");
        createFile(f, s1);
    }

    public static String[] loadFile(File f){
        String s1 = "";
        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)){
                while(true){
                    String s = br.readLine();       //逐行将文件f里的所有内容读取到字符串s中
                    //System.out.println(s);
                    if(null == s) break;
                    s1 += s + "\n";
                }
        }catch(IOException e){
            e.printStackTrace();
        }
        String[] sa = s1.split("\n");
        return sa;
    }

    public static String[] replaceInput(String[] s){
        Scanner sc = new Scanner(System.in);
        String propertyName = "";
        String typeName = "";
        System.out.println("请输入类名： ");
        className = sc.nextLine();
        System.out.println("请输入属性类型： ");
        typeName = sc.nextLine();
        System.out.println("请输入属性名： ");
        propertyName = sc.nextLine();
        sc.close();

        //proName需要设计一个首字母大写的额外单词
        char[] ca = propertyName.toCharArray();
        ca[0] = Character.toUpperCase(ca[0]);
        String propertyName2 = new String(ca);
        for(int i=0; i<s.length; i++){
            s[i] = s[i].replaceAll("()@class@", className);
            s[i] = s[i].replaceAll("@property@", propertyName);
            s[i] = s[i].replaceAll("@Uproperty@", propertyName2);
            s[i] = s[i].replaceAll("@type@", typeName);
        }
        return s;
    }
    public static void createFile(File f, String[] s){
        String s1 = f.getParent();
        s1 += "/" + className + ".java";
        File f1 = new File(s1);
        try(FileWriter fw = new FileWriter(f1);
            PrintWriter pw = new PrintWriter(fw)){
                for(int i =0; i<s.length; i++){
                    pw.println(s[i]);
                }
            System.out.println("文件生成成功， 保存在：" + f1);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}