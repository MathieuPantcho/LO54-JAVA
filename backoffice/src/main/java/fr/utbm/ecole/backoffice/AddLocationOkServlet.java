package fr.utbm.ecole.backoffice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddLocationOkServlet", urlPatterns = {"/addLocationOk"})
public class AddLocationOkServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Gestion des locations</title>");
                out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1' crossorigin='anonymous'>");                  
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Enregistrement effectué avec succès</h1>");
                out.println("<a href=/backoffice/ class=\"btn btn-primary\"  role=\"button\" style=\"margin-bottom: 5px;\" >Revenir à l'acceuil</a><br>");
                out.println("<a href=/backoffice/addLocationForm.jsp class=\"btn btn-primary\"  role=\"button\" style=\"margin-bottom: 5px;\">Revenir à manager location</a><br>");
                out.println("</body>");
                out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
