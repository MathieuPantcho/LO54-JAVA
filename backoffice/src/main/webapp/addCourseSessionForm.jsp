<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.utbm.ecole.core.entity.Course" %>
<%@page import="fr.utbm.ecole.core.service.CourseService" %>
<%@page import="fr.utbm.ecole.core.entity.CourseSession" %>
<%@page import="fr.utbm.ecole.core.service.CourseSessionService" %>
<%@page import="fr.utbm.ecole.core.entity.Location" %>
<%@page import="fr.utbm.ecole.core.service.LocationService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion des courses sessions</title>
    </head>
    <body>
        <a href="/backoffice">Retour accueil</a>
        <h1>Ajoutez une nouvelle course session : </h1>
        <form action="/backoffice/AddCourseSession" method="POST">
            <label for="startdate">Start Date : </label>
            <input type="date" id="startdate" name="startdate"
                   min="2020-01-01" max="2025-12-31">
            <br>
            <br>
            <label for="enddate">End Date : </label>
            <input type="date" id="enddate" name="enddate"
                   min="2020-01-01" max="2025-12-31">
            <br>
            <br>
            <label for="codeCourse">Code course :</label>
            <select name="codeCourse" id="codeCourse">
    <%
            CourseService cs = new CourseService();
            List<Course> listCourse = cs.listCourse();
            for (int i=0; i<listCourse.size(); i++)
            {
                Course course = (Course) listCourse.get(i) ;
                String item = course.getCode();
    %>
               <option for="codeCourse" value=<%=item%>><%=item%></option>
    <%
            }
    %>
            </select>
            <br>
            <br>
            <label for="location">City :</label>
            <select name="location" id="location">
    <%
            LocationService ls = new LocationService();
            List<Location> listLocation = ls.listLocation();
            for (int i=0; i<listLocation.size(); i++)
            {
                Location location = (Location) listLocation.get(i) ;
                String item = location.getCity();
                Integer id = location.getId();
    %>
               <option value=<%=id%>><%=item%></option>
    <%
            }
    %>
            </select>
            <br>
            <br>
            <label for="maximum">Maximum : </label>
            <input type="text" id="maximum" name="maximum" required/>
            <br>
            <br>
            <input type="submit" value="Valider"/>  
        </form>
    <%
        CourseSessionService courseSessionService = new CourseSessionService();
        List<CourseSession> listCourseSession = courseSessionService.listCourseSession();
        
    %>
        <br>
        <h1>Liste des courses sessions</h1>
        <table>
        <tr>
            <td> ID </td>
            <td> Course Code </td>
            <td> Course Title </td>
            <td> Start Date </td>
            <td> End Date </td>
            <td> Location </td>
            <td> Maximum </td>
            </tr>
            
            <%for(CourseSession css : listCourseSession){%>
                <tr>
                <td><% out.println(css.getId()); %></td>
                <td><% out.println(css.getCourse().getCode()); %></td>
                <td><% out.println(css.getCourse().getTitle()); %></td>
                <td><% out.println(css.getStartDate()); %></td>
                <td><% out.println(css.getEndDate()); %></td>
                <td><% out.println(css.getLocation().getCity()); %></td>
                <td><% out.println(css.getMaximum()); %></td>
                </tr>
            <%}%>
            </table>
            </body>
            </html>
    </body>
</html>
