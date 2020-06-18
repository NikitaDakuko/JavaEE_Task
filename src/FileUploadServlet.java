import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
        maxFileSize=1024*1024*10,
        maxRequestSize=1024*1024*50)
public class FileUploadServlet extends HttpServlet {
    private static final String SAVE_DIR = "uploadFiles";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uploadPath = getServletContext().getRealPath("") + File.separator + SAVE_DIR;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        for (Part part : req.getParts()) {
            String fileName = getFileName(part);
            part.write(uploadPath + File.separator + fileName);
        }
        req.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                req, resp);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "";
    }
}