import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

/**
 * @Auther Ashen One
 * @Date 2020/12/11
 */
@WebServlet(name = "FileUploadDemo",urlPatterns = {"/FileUploadDemo"})
public class FileUploadDemo extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        	/*
		  	* 准备： 导入两个jar文件&页面3处
		  		1. 创建工厂类
		  		2. 创建解析器ServletFileUpload//ServletFileUpload
		  		3. 使用ServletFileUpload中的List<FileItem> parseRequest(request)
		  		4. 使用FileItem中的write()方法，写到服务器。
		 */
        //1. 创建工厂类
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //2. 创建解析器ServletFileUpload//ServletFileUpload
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        //获取upload的真实路径
        String realPath = this.getServletContext().getRealPath("/upload");
        System.out.println("realPath:"+realPath);
        //设置单个文件的上传大小
        servletFileUpload.setFileSizeMax(2*1024);
        //3. 使用ServletFileUpload中的List<FileItem> parseRequest(request)
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                //判断是否是文件
                if (!fileItem.isFormField()){
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    String filePath = realPath+"/"+uuid+fileItem.getName();
                    File file = new File(filePath);
                    //4. 使用FileItem中的write()方法，写到服务器。
                    fileItem.write(file);
                }

            }
        } catch (FileSizeLimitExceededException e) {
            writer.write("单个文件大小不能超过2k");
            e.printStackTrace();}
        catch (Exception e) {
            e.printStackTrace();

        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
