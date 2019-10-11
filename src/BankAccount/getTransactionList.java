package BankAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getTransactionList")
public class getTransactionList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        List<String> transactions = (List<String>) httpSession.getAttribute("transactionList");
//        Transfer balance = (Transfer) httpSession.getAttribute("result");
        resp.getWriter().println("transactions carried out: " + transactions);
//        resp.getWriter().println("account balance: " + balance);
//        jak dodac mechanizm obliczania stanu konta po kazdej operacji?
    }
}