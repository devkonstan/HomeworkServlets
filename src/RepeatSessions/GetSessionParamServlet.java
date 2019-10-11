package RepeatSessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//    http://localhost:8080/getsession
@WebServlet("/getsession")
public class GetSessionParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Read from session");
        HttpSession httpSession = req.getSession(true);
        String param = (String) httpSession.getAttribute("paramSession");
        printWriter.println("Param: " + param);
    }

}
