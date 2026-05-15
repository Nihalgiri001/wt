import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

public class CurrencyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        double amt=Double.parseDouble(req.getParameter("amount"));
        String from=req.getParameter("from");
        String to=req.getParameter("to");
        double result=amt;

        if(from.equals("INR") && to.equals("USD")) result=amt/83;
        else if(from.equals("USD") && to.equals("INR")) result=amt*83;
        else if(from.equals("INR") && to.equals("EUR")) result=amt/90;
        else if(from.equals("EUR") && to.equals("INR")) result=amt*90;
        else if(from.equals("USD") && to.equals("EUR")) result=amt*0.92;
        else if(from.equals("EUR") && to.equals("USD")) result=amt*1.08;

        req.setAttribute("amount", amt);
        req.setAttribute("from", from);
        req.setAttribute("to", to);
        req.setAttribute("result", result);

        RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
        rd.forward(req,res);
    }
}