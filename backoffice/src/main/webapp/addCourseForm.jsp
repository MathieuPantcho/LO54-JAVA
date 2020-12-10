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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="margin: 1em">
        <a href="/backoffice" class="btn btn-primary"  role="button">Retour accueil</a>
       <hr>
       <h1>Ajoutez un nouveau cours: </h1>
       <div class="container">
            <div class="row">
  		<div class="col-md-6">
                         <div class="form-group">
                             <form action="/backoffice/addcourse" method="POST">
                                    <label for="code">Titre du Code : </label>
                                    <input type="text" id="code" name="code" minlength="2" class="form-control" required/>
                                    <label for="title">Titre du Title : </label>
                                    <input type="text" id="title" name="title" minlength="3" class="form-control" required/>
                                    <input type="submit" class="btn btn-primary" value="Valider"/>            
                             </form>
                         </div>
                  </div>
            </div>
        </div>
        <hr>
        <h1>Liste des Courses BDD </h1>
        <table  class="table">
            <tr class="table-primary">
                  <td class="table-primary">Code</td>
                  <td class="table-primary">Title</td>
            </tr>
            <% for(Course c : listCourse){ %>
            <tr class="table-primary">

                 <td class="table-primary"><% out.println(c.getCode());%></td>
                 <td class="table-primary"><% out.println(c.getTitle());%></td>

            </tr>
            <% }%>
        </table>
        <hr>
        <h1>Liste des Courses Redis </h1>
        <table  class="table">
            <tr class="table-primary">
                  <td class="table-primary">Code</td>
                  <td class="table-primary">Title</td>
            </tr>
        <% for(Course c : listCourseRedis){ %>
            <tr class="table-primary">

                 <td class="table-primary"><% out.println(c.getCode());%></td>
                 <td class="table-primary"><% out.println(c.getTitle());%></td>

            </tr>
        <% }%>
        </table>
    </body>
</html>
