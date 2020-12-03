package fr.utbm.ecole.backoffice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddCourseKOServlet", urlPatterns = {"/addCourseKO"})
public class AddCourseKOServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Gestion des courses</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erreur lors de l'ajout d'un cours</h1>");
                out.println("<a href=/backoffice/>Revenir à l'acceuil</a><br>");
                out.println("<a href=/backoffice/addCourseForm.jsp>Réesayer l'ajout</a><br>");
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