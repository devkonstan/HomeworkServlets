package RepeatSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//    http://localhost:8080/setsession?param=1
@WebServlet("/setsession")
public class SetSessionParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqParam = req.getParameter("param");
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("paramSession", reqParam);
        resp.getWriter().println("added param to session: " + reqParam);
    }

}
