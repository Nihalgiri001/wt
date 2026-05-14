import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        if(u.equals("vinati123") && p.equals("Pass123")){
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            res.sendRedirect("dashboard.jsp");
        }
        else{
            res.getWriter().println("Invalid Login");
        }
    }
}