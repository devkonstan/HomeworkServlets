package Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/validate")
public class Validation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reg = "[a-z0-9_.-]+@[a-z0-9_.-]+\\.\\w{2,4}";
        String email = req.getParameter("email");
        if (email != null && email.matches(reg)) {
            resp.getWriter().println("email is valid ");
        } else {
            resp.getWriter().println("email is not valid ");
        }

        String regex = "[0-9]{2}-[0-9]{3}";
        String code = req.getParameter("post");
        if (code != null && code.matches(regex)) {
            resp.getWriter().println("code is valid ");
        } else {
            resp.getWriter().println("code is not valid ");
        }

        String phone = req.getParameter("number");
        if (phone != null && phone.startsWith("+48") && phone.length() == 12) {
            resp.getWriter().println("number is valid ");
        } else {
            resp.getWriter().println("number is not valid ");
        }


        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("email", email);
        httpSession.setAttribute("number", phone);
        httpSession.setAttribute("post", code);
    }
}

