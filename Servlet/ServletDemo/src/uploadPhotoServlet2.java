import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class uploadPhotoServlet2 {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String filename = null;
        try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //�����ļ���С
            factory.setSizeThreshold(1024 * 1024);

            List items = null;
            try{
                //��request�н���������
                items = upload.parseRequest(request);
            }catch(FileUploadException e){
                e.printStackTrace();
            }

            //�����������Ĳ�����
            Iterator iter = items.iterator();
            while(iter.hasNext()){
                //request����������ת����file
                FileItem item = (FileItem) iter.next();
                //TODO  isFormField,�ж�����ͨ�ı����������ļ��ϴ���,ǰ��Ϊtrue����Ϊfalse,����Ҫ��������Ӧ���ļ��ϴ�����
                if(!item.isFormField()){
                    filename = System.currentTimeMillis() + ".jpg";
                    //�ļ�·���������ھʹ���
                    String photoFolder = request.getServletContext().getRealPath("uploaded");
                    //·�����ļ���
                    File f = new File(photoFolder, filename);
                    //Ŀ¼�����ھʹ���һ��
                    f.getParentFile().mkdirs();

                    //ͨ��item.getInputStre
                    InputStream is = item.getInputStream();
                    
                    //�����ļ�
                    //TODO ��ʵ�ǰ��ϴ���ͼƬ������һ�鵽��ӦĿ¼
                    FileOutputStream fos = new FileOutputStream(f);
                    byte[] b = new byte[1024 * 1024];
                    int length = 0;
                    while(-1 != (length = is.read(b))){
                        fos.write(b, 0, length);
                    }
                    fos.close();
                }else{
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes("ISO-8859-1"), "utf-8");
                    System.out.println(value);
                }
            }
            String html = "<img width='200' height='150'src='uploaded/%s' />";
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
