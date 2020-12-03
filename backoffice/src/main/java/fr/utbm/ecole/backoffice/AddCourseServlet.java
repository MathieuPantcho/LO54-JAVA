package fr.utbm.ecole.backoffice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.ecole.core.entity.Course;
import fr.utbm.ecole.core.service.CourseService;

@WebServlet(name = "AddCourseServlet", urlPatterns = {"/addcourse"})
public class AddCourseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCourseServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourseServlet at " + request.getContextPath() + "</h1>");
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
        Map<String,String[]> form = request.getParameterMap();
        String code = form.get("code")[0];
        String title = form.get("title")[0];
        CourseService cs = new CourseService();
        Course ct = cs.searchCourseById(code);
        if(code !=null && title !=null && ct == null ){
            Course c = new Course(code,title);
            cs.registerCourse(c); 
            response.sendRedirect("/backoffice/addCourseOk");
        }else{
            response.sendRedirect("/backoffice/addCourseKO");            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
