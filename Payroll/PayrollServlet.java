import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/payroll")
public class PayrollServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name=req.getParameter("name");
        double basic=Double.parseDouble(req.getParameter("basic"));
        double hraPercent=Double.parseDouble(req.getParameter("hra"));
        double bonus=Double.parseDouble(req.getParameter("bonus"));

        double hra=(basic*hraPercent)/100;
        double gross=basic+hra+bonus;

        req.setAttribute("name", name);
        req.setAttribute("basic", basic);
        req.setAttribute("hra", hra);
        req.setAttribute("bonus", bonus);
        req.setAttribute("gross", gross);

        RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
        rd.forward(req,res);
    }
}