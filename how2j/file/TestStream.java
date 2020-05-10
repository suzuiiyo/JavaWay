package file;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestStream {
    public static void main(String[] args){
        try{
            File f = new File("d:/Studio/JavaWay/AC/DC/testStream.txt");
            //׼��������2���ֽ�����,��88��89��ʼ�������Ӧ���ַ��ֱ���X,Y

            //���Ȼ�ȡ�ļ�����Ŀ¼
            File dir = f.getParentFile();
            //�����Ŀ¼����զ,�򴴽���Ŀ¼
            if(!dir.exists()){
                //dir.mkdir(); //ʹ��mkdir���׳��쳣,��Ϊ��Ŀ¼�ĸ�Ŀ¼Ҳ������
                dir.mkdirs(); //ʹ��mkdirs���Ѳ����ڵ�Ŀ¼��������
            }
            byte data[] = new byte[123];
            for(byte i=0; i<120; i++){
                data[i] = i;
            }
            //���������ļ���������
            //FileInputStream fis = new FileInputStream(f);
            //ͨ��������������Ϳ��԰����ݴ�Ӳ�̣���ȡ��JVM�У�Ҳ���Ƕ�ȡ���ڴ���
            FileOutputStream fos  = new FileOutputStream(f);
            //ͨ�������������Ϳ��԰����ݴ��ڴ��У���ȡ��Ӳ����
            fos.write(data);
            //�ر������
            fos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}