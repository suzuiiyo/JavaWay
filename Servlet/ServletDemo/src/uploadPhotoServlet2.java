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
            //限制文件大小
            factory.setSizeThreshold(1024 * 1024);

            List items = null;
            try{
                //从request中解析参数域
                items = upload.parseRequest(request);
            }catch(FileUploadException e){
                e.printStackTrace();
            }

            //遍历解析出的参数域
            Iterator iter = items.iterator();
            while(iter.hasNext()){
                //request解析出来的转换成file
                FileItem item = (FileItem) iter.next();
                //TODO  isFormField,判断是普通的表单输入域还是文件上传域,前者为true后者为false,后者要对域做相应的文件上传处理
                if(!item.isFormField()){
                    filename = System.currentTimeMillis() + ".jpg";
                    //文件路径，不存在就创建
                    String photoFolder = request.getServletContext().getRealPath("uploaded");
                    //路径的文件名
                    File f = new File(photoFolder, filename);
                    //目录不存在就创建一个
                    f.getParentFile().mkdirs();

                    //通过item.getInputStre
                    InputStream is = item.getInputStream();
                    
                    //复制文件
                    //TODO 其实是把上传的图片复制了一遍到对应目录
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
