import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/result")
public class BigShaqServlet extends HttpServlet {

    public static final Logger logger = LogManager.getLogger(BigShaqServlet.class);

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        logger.info("used post");

        int nom = Integer.parseInt(req.getParameter("nom"));

        logger.info("got attribute nom = " + nom);
        nom*=nom;   //quick maffs

        req.setAttribute("nom", nom);

        logger.info("forwarding with nom = " + nom);
        req.getRequestDispatcher("result.jsp").forward(req, res);
    }
}
