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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <title>Gestion des courses sessions</title>
    </head>
    <body style="margin: 1em">
        <a href="/backoffice" class="btn btn-primary"  role="button">Retour accueil</a>
        <hr>
        <h1>Ajoutez une nouvelle course session : </h1>
        <div class="container">
        <div class="row">
  	<div class="col-md-6">
        <div class="form-group">
        <form action="/backoffice/AddCourseSession" method="POST">
            <label for="startdate">Start Date : </label>
            <input type="date" id="startdate" name="startdate"
                   min="2020-01-01" max="2025-12-31" class="form-control">
            <br>
            <br>
            <label for="enddate">End Date : </label>
            <input type="date" id="enddate" name="enddate"
                   min="2020-01-01" max="2025-12-31" class="form-control">
            <br>
            <br>
            <label for="codeCourse">Code course :</label>
            <select name="codeCourse" id="codeCourse" class="form-control">
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
            <select name="location" id="location" class="form-control">
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
            <input type="text" id="maximum" name="maximum" class="form-control" />
            <br>
            <br>
            <input type="submit" value="Valider" class="btn btn-primary" />  
        </form>
        </div>
        </div>
        </div>
        </div>
    <%
        CourseSessionService courseSessionService = new CourseSessionService();
        List<CourseSession> listCourseSession = courseSessionService.listCourseSession();
        
    %>
        <br>
        <h1>Liste des courses sessions</h1>
        <table  class="table">
        <tr class="table-primary">
            <td class="table-primary"> ID </td>
            <td class="table-primary"> Course Code </td>
            <td class="table-primary"> Course Title </td>
            <td class="table-primary"> Start Date </td>
            <td class="table-primary"> End Date </td>
            <td class="table-primary"> Location </td>
            <td class="table-primary"> Maximum </td>
            <td class="table-primary"> Pourcentage </td>
            </tr>
            
            <%for(CourseSession css : listCourseSession){
           
            if(css.getMaximum()!=null){ %>
                 <tr class="table-primary">
                <td class="table-primary"><% out.println(css.getId()); %></td>
                <td class="table-primary"><% out.println(css.getCourse().getCode()); %></td>
                <td class="table-primary"><% out.println(css.getCourse().getTitle()); %></td>
                <td class="table-primary"><% out.println(css.getStartDate()); %></td>
                <td class="table-primary"><% out.println(css.getEndDate()); %></td>
                <td class="table-primary"><% out.println(css.getLocation().getCity()); %></td>
                <td class="table-primary"><% out.println(css.getMaximum()); %></td>
                <td class="table-primary"><%
                    float pourcentage = Math.round((courseSessionService.GetNbClientCourseSession(css)/css.getMaximum())*100 );
                    out.println( pourcentage); %></td>
                </tr>
                <%
            }else{%>
                 <tr class="table-primary">
                <td class="table-primary"><% out.println(css.getId()); %></td>
                <td class="table-primary"><% out.println(css.getCourse().getCode()); %></td>
                <td class="table-primary"><% out.println(css.getCourse().getTitle()); %></td>
                <td class="table-primary"><% out.println(css.getStartDate()); %></td>
                <td class="table-primary"><% out.println(css.getEndDate()); %></td>
                <td class="table-primary"><% out.println(css.getLocation().getCity()); %></td>
                <td class="table-primary">N/A</td>
                <td class="table-primary"></td>
                </tr>
            <%}}%>
            </table>
            
            </body>
            </html>
    </body>
</html>
