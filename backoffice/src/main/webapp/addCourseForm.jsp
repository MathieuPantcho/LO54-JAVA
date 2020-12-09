<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.utbm.ecole.core.service.CourseService" %>
<%@page import="fr.utbm.ecole.core.service.CourseServiceRedis" %>
<%@page import="fr.utbm.ecole.core.entity.Course" %>
<%@page import="java.util.List" %>

<% CourseService courseService = new CourseService() ; %>
<% List<Course> listCourse = courseService.listCourse(); %>
<% CourseServiceRedis courseServiceRedis = new CourseServiceRedis() ; %>
<% List<Course> listCourseRedis = courseServiceRedis.seeAllValues(); %>

<!DOCTYPE html>
<html>
    <head>
        <title>Gestion des courses</title>
        <link rel="stylesheet" href="@{/webjars/bootstrap/css/bootstrap.min.css}">
        <script src="@{/webjars/jquery/jquery.min.js}"></script>
        <script src="@{/webjars/popper.js/umd/popper.min.js}"></script>
        <script src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <a href="/backoffice">Retour accueil</a>
       <h1>Ajoutez un nouveau cours: </h1>
        <div class="form-group">
            <form action="/backoffice/addcourse" method="POST">
                <label for="code">Titre du Code : </label>
                <input type="text" id="code" name="code" minlength="2" class="form-control" required/>
                <label for="title">Titre du Title : </label>
                <input type="text" id="title" name="title" minlength="3" class="form-control" required/>
                <input type="submit" value="Valider"/>            
            </form>
        </div>
        <h1>Liste des Courses BDD </h1>
        <ul class="list-group">
        <% for(Course c : listCourse){ %>
              <li class="list-group-item"> <% out.println(c.getCode());%> : <% out.println(c.getTitle());%> </li>
        <% }%>
        </ul>
        <br>
        <h1>Liste des Courses Redis </h1>
        <ul class="list-group">
        <% for(Course c : listCourseRedis){ %>
              <li class="list-group-item"> <% out.println(c.getCode());%> : <% out.println(c.getTitle());%> </li>
        <% }%>
        </ul>
    </body>
</html>
