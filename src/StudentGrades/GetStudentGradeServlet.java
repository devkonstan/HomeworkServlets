package StudentGrades;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getgrades")
public class GetStudentGradeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
//        List<String> grades = (List<String>) session.getAttribute("subject");
//        resp.getWriter().println("grades: " + grades);

        for (Subject subject : Subject.values()) {
            resp.getWriter().printf("%s: %s\n",
                    subject.getDisplayName(),
                    session.getAttribute(subject.getSessionKey()));
        }
    }
}
