<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.utbm.ecole.core.entity.Client" %>
<%@page import="fr.utbm.ecole.core.service.ClientService" %>
<%@page import="fr.utbm.ecole.core.entity.CourseSession" %>
<%@page import="fr.utbm.ecole.core.service.CourseSessionService" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <title>Gestion des clients</title>
    </head>
    <body style="margin: 1em">
        <a href="/backoffice" class="btn btn-primary"  role="button">Retour accueil</a>
       <hr>        
       
    <%
        ClientService clientService = new ClientService();
        List<Client> listClient = clientService.listClient();
        
    %>
        <h1>Liste des Clients</h1>
        <table class="table">
        <tr class="table-primary">
            <td class="table-primary"> ID </td>
            <td class="table-primary"> LASTNAME </td>
            <td class="table-primary"> FIRSTNAME </td>
            <td class="table-primary"> ADDRESS </td>
            <td class="table-primary"> EMAIL </td>
            <td class="table-primary"> COURSE_SESSION_ID </td>
            <td class="table-primary"> PHONE </td>
            </tr>
            
            <%for(Client c : listClient){%>
                <tr class="table-primary">
                <td class="table-primary"><% out.println(c.getId()); %></td>
                <td class="table-primary"><% out.println(c.getLastname()); %></td>
                <td class="table-primary"><% out.println(c.getFirstname()); %></td>
                <td class="table-primary"><% out.println(c.getAddress()); %></td>
                <td class="table-primary"><% out.println(c.getEmail()); %></td>
                <td class="table-primary"><% out.println(c.getCourseSession().getId()); %></td>
                <td class="table-primary"><% out.println(c.getPhone()); %></td>
                </tr>
            <%}%>
            </table>
            </body>
            </html>
    </body>
</html>

