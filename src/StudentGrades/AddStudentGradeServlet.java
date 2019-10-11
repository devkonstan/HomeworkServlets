package StudentGrades;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addgrades")
public class AddStudentGradeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        int grade = Integer.parseInt(req.getParameter("grade"));
        HttpSession session = req.getSession(true);

        List<Integer> scores = (List<Integer>) session.getAttribute(subject);
        if (scores == null) {
            scores = new ArrayList<>();
        }
        scores.add(grade);

        session.setAttribute("subject", grade);
        resp.getWriter().println("Set score!");
    }
}
