/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.backoffice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.service.CourseSessionService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author MathieuPANTCHENKO
 */
@WebServlet(name = "ListCourseSessionServlet", urlPatterns = {"/CourseSession"})
public class ListCourseSessionServlet extends HttpServlet {
    
    CourseSessionService courseSessionService;
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
        courseSessionService = new CourseSessionService();
        List<CourseSession> listCourseSession = courseSessionService.listCourseSession();
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ecole</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Liste des courses sessions</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td> ID </td>");
            out.println("<td> Course Code </td>");
            out.println("<td> Course Title </td>");
            out.println("<td> Start Date </td>");
            out.println("<td> End Date </td>");
            out.println("<td> Location </td>");
            out.println("<td> Maximum </td>");
            out.println("</tr>");
            
            for(CourseSession cs : listCourseSession){
                out.println("<tr>");
                out.println("<td>"  + cs.getId() + "</td>");
                out.println("<td>"  + cs.getCourse().getCode() + "</td>");
                out.println("<td>"  + cs.getCourse().getTitle() + "</td>");
                out.println("<td>"  + cs.getStartDate() + "</td>");
                out.println("<td>"  + cs.getEndDate() + "</td>");
                out.println("<td>"  + cs.getLocation().getCity() + "</td>");
                out.println("<td>"  + cs.getMaximum() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
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
        processRequest(request, response);
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
