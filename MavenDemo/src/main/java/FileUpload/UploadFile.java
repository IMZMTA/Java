package FileUpload;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadFile", value = "/upload")
@MultipartConfig
public class UploadFile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<Part> multifiles = (List<Part>) request.getParts();

            for(Part item : multifiles){
                String fileName = extractFileName(item);
                item.write("C:\\Intelli - Java\\Web-Project\\MavenDemo\\UploadMultiFileFolder" + File.separator + fileName);
            }
            System.out.println("File uploaded successfully");
        } catch (IOException | ServletException e) {
            throw new ServletException("Error processing uploaded file." +e);
        }
    }
    private String extractFileName(Part item) {
        String cd = item.getHeader("content-disposition");
        String[] items = cd.split(" ");
        for(String i : items){
            if(i.trim().startsWith("filename")){
                return  i.substring(i.indexOf("=")+2,i.length()-1);
            }
        }
        return "unknown";
    }
}