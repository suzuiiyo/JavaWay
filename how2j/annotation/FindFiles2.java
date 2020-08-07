package annotation;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO Ϊ�˽����������ע����Ϊ�ڲ������ʽ����һ���ļ���
//TODO 1.ע��FileTypes, ��value()����һ��FileType����
//TODO 2 ע��FileType, ��@Repeatable��ֵ����FileTypeע��
//TODO 3 ����ע�⣺��work�������ظ�ʹ�ö��@FileTypeע��
//TODO 4 ����ע��:��work�����ڣ�ͨ�������ȡ���������ϵ�FileType���͵�ע������,Ȼ�����������
public class FindFiles2 {
    @Target( METHOD)
    @Retention( RetentionPolicy.RUNTIME )
    //�ڲ���,����ֵ�ļ���������
    public @interface FileTypes{
        FileType[] value();
    };

    @Target( METHOD)
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( FileTypes.class)
    //�ڲ���,����ֵ�ļ�������
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
            System.out.println("�������º�׺�����ļ��в����ļ�����");
            for(FileType fileType : fileTypes){
                System.out.println(fileType.value());
            }
            System.out.println("���ҹ�����....");
        }catch(NoSuchMethodException | SecurityException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles2().work();
    }
}