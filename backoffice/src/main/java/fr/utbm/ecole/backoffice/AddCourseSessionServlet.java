
package fr.utbm.ecole.backoffice;

import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.service.CourseService;
import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.service.CourseSessionService;
import fr.utbm.ecole.core.entity.Location;
import fr.utbm.ecole.core.service.LocationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddCourseSessionServlet", urlPatterns = {"/AddCourseSession"})
public class AddCourseSessionServlet extends HttpServlet {
    List<CourseSession> listCourseSession;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gestion des courses sessions</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourseSessionServlet at " + request.getContextPath() + "</h1>");
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
        CourseSessionService courseSessionService = new CourseSessionService();
        
        this.listCourseSession = courseSessionService.listCourseSession();
        
	request.setAttribute( "listCourseSession", this.listCourseSession );
	this.getServletContext().getRequestDispatcher( "addCourseSessionForm.jsp" ).forward( request, response );
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
        String startdate = form.get("startdate")[0];
        String enddate = form.get("enddate")[0];
        String strCourse = form.get("codeCourse")[0];
        CourseService cs = new CourseService();
        Course course = cs.searchCourseById(strCourse);
        String strLocation = form.get("location")[0];
        Integer intLocation = Integer.parseInt(strLocation);
        LocationService ls = new LocationService();
        Location location = ls.searchLocationById(intLocation);
        Integer maximum = null;
        if(!form.get("maximum")[0].equals("")){
            String strMaxi = form.get("maximum")[0];
            maximum = Integer.parseInt(strMaxi);
        }
        
        
        if(course !=null && location !=null && startdate != null && enddate != null && maximum != null ){
            try {
                CourseSession csSec = new CourseSession();
                csSec.setStartDate(startdate);
                csSec.setEndDate(enddate);
                csSec.setMaximum(maximum);
                csSec.setCourse(course);
                csSec.setLocation(location);
                CourseSessionService css = new CourseSessionService();
                css.registerCourseSession(csSec);
                response.sendRedirect("/backoffice/AddCourseSessionOKServlet");
            } catch (ParseException ex) {
                Logger.getLogger(AddCourseSessionServlet.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("/backoffice/AddCourseSessionKOServlet");      
            }
        }else{
            if( maximum == null ){
                try {
                    CourseSession csSec = new CourseSession();
                    csSec.setStartDate(startdate);
                    csSec.setEndDate(enddate);
                    csSec.setCourse(course);
                    csSec.setLocation(location);
                    CourseSessionService css = new CourseSessionService();
                    css.registerCourseSession(csSec);
                    response.sendRedirect("/backoffice/AddCourseSessionOKServlet");
                } catch (ParseException ex) {
                    Logger.getLogger(AddCourseSessionServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.sendRedirect("/backoffice/AddCourseSessionKOServlet");      
                }
            }else{
                response.sendRedirect("/backoffice/AddCourseSessionKOServlet");            
            }            
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
