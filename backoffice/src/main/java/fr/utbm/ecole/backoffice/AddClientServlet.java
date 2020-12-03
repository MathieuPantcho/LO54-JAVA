/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.backoffice;

import fr.utbm.ecole.core.entity.Client;
import fr.utbm.ecole.core.service.ClientService;
import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.service.CourseSessionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MathieuPANTCHENKO
 */
@WebServlet(name = "addClientServlet", urlPatterns = {"/addClient"})
public class AddClientServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addClientServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,String[]> form = request.getParameterMap();
        String firstname = form.get("firstname")[0];
        String lastname = form.get("lastname")[0];
        String address = form.get("address")[0];
        String email = form.get("email")[0];
        String phone = form.get("phone")[0];
        String courseSession = form.get("courseSession")[0];
        CourseSessionService css = new CourseSessionService();
        CourseSession cs = css.searchCourseSessionById(Integer.parseInt(courseSession));
        if(firstname !=null && lastname !=null && address !=null && email !=null && phone !=null && cs !=null){
            ClientService clientService = new ClientService();
            Client c = new Client();
            c.setFirstname(firstname);
            c.setLastname(lastname);
            c.setAddress(address);
            c.setEmail(email);
            c.setPhone(phone);
            c.setCourseSession(cs);
            clientService.registerClient(c); 
            response.sendRedirect("/backoffice/AddClientOK");
        }else{
            response.sendRedirect("/backoffice/AddClientKO");            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
