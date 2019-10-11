package StudentGrades;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet("/studentsummary")
public class StudentGradesSummaryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String subject = req.getParameter("subject");
        HttpSession httpSession = req.getSession(true);
        List<Integer> results = (List<Integer>) httpSession.getAttribute(subject);
        double average = results.stream()
                .mapToInt(value -> value)
                .average()
                .orElse(0);

        int max = Collections.max(results);
        int min = Collections.min(results);
        printWriter.println("Srednia: " + average);
        printWriter.println("Max: " + max);
        printWriter.println("Min: " + min);
    }

}
