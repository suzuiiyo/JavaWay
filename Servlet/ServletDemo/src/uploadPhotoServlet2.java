import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig //���ע��ز�����
public class UploadPhotoServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
            ServletException {
        /*String filename = null;
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
        }*/
        response.getWriter().println("post!!!!!");
        Part upFile = request.getPart("filepath");
        String upLoadPath = request.getServletContext().getRealPath("uploaded");
        String fileName = upFile.getName() + System.currentTimeMillis() + ".jpg";
        File f = new File(upLoadPath, fileName);
        f.getParentFile().mkdirs();

        try(InputStream is = upFile.getInputStream(); FileOutputStream fos = new FileOutputStream(f)){
            byte[] buffer = new byte[1024 * 1024];
            int length = 0;
            while((length = is.read(buffer))>-1){
                fos.write(buffer, 0, length);
            }

            String imgPath = f.getName();
            String html = String.format("<img width='300' height='650' src='uploaded/%s' />", imgPath);
            response.setContentType("text/html");
            //PrintWriter pw = response.getWriter();
            //pw.format(html, fileName);
            response.getWriter().println(html);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
    }
}
