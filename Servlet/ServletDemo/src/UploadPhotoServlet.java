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
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置上传文件的大小限制为1M
            factory.setSizeThreshold(1024 * 1024);

            List items = null;
            try{
                items = upload.parseRequest(request);
            }catch(FileUploadException e){
                e.printStackTrace();
            }

            //迭代器遍历
            Iterator iter = items.iterator();
            while(iter.hasNext()){
                FileItem item = (FileItem) iter.next();
                if(!item.isFormField()){
                    //根据时间戳创建头像文件
                    filename = System.currentTimeMillis() + ".jpg";
                    //通过getRealPath获取上传文件夹，如果项目在D:\Studio\JavaWay\Servlet\ServletDemo\web,那么就会/project/j2ee/web/uploaded
                    String photoFolder = request.getServletContext().getRealPath("uploaded");
                    //路径和文件名
                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();

                    //通过item.getInputStream()获取浏览器上传的文件的输入流
                    InputStream is = item.getInputStream();

                    //复制文件
                    FileOutputStream fos = new FileOutputStream(f);
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    //输入流读到数组
                    while(-1 != (length = is.read(b))){
                        //把数组b的内容写到文件f
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
            String html = "<img width='200' height='150' src='uploaded/%s' />";
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            pw.format(html, filename);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
    }
}
