import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/admission")
public class AdmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name=req.getParameter("name");
        double per=Double.parseDouble(req.getParameter("percentage"));
        int entrance=Integer.parseInt(req.getParameter("entrance"));

        String result=(per>=70 && entrance>=60) ? "Eligible" : "Not Eligible";

        req.setAttribute("name", name);
        req.setAttribute("per", per);
        req.setAttribute("entrance", entrance);
        req.setAttribute("result", result);

        RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
        rd.forward(req,res);
    }
}