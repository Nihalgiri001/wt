import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setAttribute("total", req.getParameter("total"));

        RequestDispatcher rd = req.getRequestDispatcher("summary.jsp");
        rd.forward(req, res);
    }
}