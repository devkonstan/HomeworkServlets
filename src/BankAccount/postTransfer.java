package BankAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/addTransaction")
public class postTransfer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Float balance =0.0f;

        Float amount = Float.parseFloat(req.getParameter("amount"));
        String line = req.getParameter("date"); //jak wykorzystac tu klase Date(albo LocalDate?)
        //String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        String[] date = line.split("/");
//        Set<Integer> dataOfDate = Stream.of(date)
//                .map((String data) -> Integer.parseInt(data))
//                .collect(Collectors.toSet());

        String title = req.getParameter("title");
        String type = req.getParameter("type"); //chcialbym tu enuma wsadzic
        Transfer transfer = new Transfer(amount, date, title, type);
        HttpSession httpSession = req.getSession(true);

        List<Transfer> payments = (List<Transfer>) httpSession.getAttribute("transactionList");
        if (payments == null) {
            payments = new ArrayList<>();
        }
        payments.add(transfer);
        httpSession.setAttribute("transactionList", payments);
        resp.getWriter().println("Transactions done " + payments);
    }
}

