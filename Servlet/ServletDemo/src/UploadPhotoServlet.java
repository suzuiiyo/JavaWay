import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadPhotoServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String filename = null;
        try{
            //����DiskFileItemFactory����,���û�������С����ʱ�ļ�Ŀ¼
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //ʹ��DiskFileItemFactory���󴴽�ServletFileUpload����
            ServletFileUpload upload = new ServletFileUpload(factory);
            //�����ϴ��ļ��Ĵ�С����Ϊ1M
            factory.setSizeThreshold(1024 * 1024);

            List items = null;
            try{
                //��request������н����õ��ֶ�
                items = upload.parseRequest(request);
            }catch(FileUploadException e){
                e.printStackTrace();
            }

            //����������
            Iterator iter = items.iterator();
            while(iter.hasNext()){
                FileItem item = (FileItem) iter.next();
                if(!item.isFormField()){
                    //����ʱ�������ͷ���ļ�
                    filename = System.currentTimeMillis() + ".jpg";
                    //ͨ��getRealPath��ȡ�ϴ��ļ��У������Ŀ��D:\Studio\JavaWay\Servlet\ServletDemo\web,��ô�ͻ�/project/j2ee/web/uploaded
                    String photoFolder = request.getServletContext().getRealPath("uploaded");
                    //·�����ļ���
                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();

                    //TODO  ͨ��item.getInputStream()��ȡ������ϴ����ļ�item��������
                    /*InputStream is = item.getInputStream();

                    //�����ļ�
                    FileOutputStream fos = new FileOutputStream(f);
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    //��������������
                    while(-1 != (length = is.read(b))){
                        //������b������д���ļ�f
                        fos.write(b, 0, length);
                    }
                    fos.close();*/

                    item.write(f);

                }else{
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "utf-8");
                    System.out.println(value);
                }
            }
            String html = "<img width='300' height='650' src='uploaded/%s' />";
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            pw.format(html, filename);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}