<%-- 
    Document   : addCourseSessionJsp
    Created on : 2 déc. 2020, 17:30:35
    Author     : MathieuPANTCHENKO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.utbm.ecole.core.entity.Course" %>
<%@page import="fr.utbm.ecole.core.service.CourseService" %>
<%@page import="fr.utbm.ecole.core.entity.Location" %>
<%@page import="fr.utbm.ecole.core.service.LocationService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>addCourseSession</title>
    </head>
    <body>
        <h1>Ajoutez une nouvelle course session : </h1>
        <form action="/backoffice/AddCourseSession" method="POST">
            <label for="startdate">Start Date : </label>
            <input type="text" id="startdate" name="startdate" required/>
            <br>
            <br>
            <label for="enddate">End Date : </label>
            <input type="text" id="enddate" name="enddate" required/>
            <br>
            <br>
            <label for="codeCourse">Code course :</label>
            <select>
    <%
            CourseService cs = new CourseService();
            List<Course> listCourse = cs.listCourse();
            for (int i=0; i<listCourse.size(); i++)
            {
                Course course = (Course) listCourse.get(i) ;
                String item = course.getCode();
    %>
               <option value="<%=course%>"><%=item%></option>
    <%
            }
    %>
            </select>
            <br>
            <br>
            <label for="location">City :</label>
            <select>
    <%
            LocationService ls = new LocationService();
            List<Location> listLocation = ls.listLocation();
            for (int i=0; i<listLocation.size(); i++)
            {
                Location location = (Location) listLocation.get(i) ;
                String item = location.getCity();
    %>
               <option value="<%=location%>"><%=item%></option>
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
    </body>
</html>
