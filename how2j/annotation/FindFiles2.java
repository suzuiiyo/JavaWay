package annotation;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO 为了紧凑起见，把注解作为内部类的形式放在一个文件里
//TODO 1.注解FileTypes, 其value()返回一个FileType数组
//TODO 2 注解FileType, 其@Repeatable的值采用FileType注解
//TODO 3 运用注解：在work方法上重复使用多次@FileType注解
//TODO 4 解析注解:在work方法内，通过反射获取到本方法上的FileType类型的注解数组,然后遍历本数组
public class FindFiles2 {
    @Target( METHOD)
    @Retention( RetentionPolicy.RUNTIME )
    //内部类,返回值文件类型数组
    public @interface FileTypes{
        FileType[] value();
    };

    @Target( METHOD)
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( FileTypes.class)
    //内部类,返回值文件类型名
    public @interface FileType{
        String value();
    };

    @FileType( ".java")
    @FileType( ".html")
    @FileType( ".css")
    @FileType( ".js")
    @FileType( ".txt")
    @FileType( ".jpeg")
    public void work(){
        try{
            FileType[] fileTypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
            System.out.println("将从如下后缀名的文件中查找文件内容");
            for(FileType fileType : fileTypes){
                System.out.println(fileType.value());
            }
            System.out.println("查找过程略....");
        }catch(NoSuchMethodException | SecurityException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles2().work();
    }
}