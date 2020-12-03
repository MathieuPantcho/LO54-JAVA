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
        <title>Gestion des clients</title>
    </head>
    <body>
        <a href="/backoffice">Retour accueil</a>
        <h1>Ajoutez un nouveau client : </h1>
        <form action="/backoffice/addClient" method="POST">
            <label for="firstname">Firstname : </label>
            <input type="text" id="firstname" name="firstname" required/>
            <br>
            <br>
            
            <label for="lastname">Lastname : </label>
            <input type="text" id="lastname" name="lastname" required/>
            <br>
            <br>
            
            <label for="address">Address : </label>
            <input type="text" id="address" name="address" required/>
            <br>
            <br>
            
            <label for="phone">Phone : </label>
            <input type="text" id="phone" name="phone" required/>
            <br>
            <br>
            
            <label for="email">Email : </label>
            <input type="text" id="email" name="email" required/>
            <br>
            <br>
            
            <label for="courseSession">Course Session : </label>
            <select name="courseSession" id="courseSession">
    <%
            CourseSessionService css = new CourseSessionService();
            List<CourseSession> courseSessionService = css.listCourseSession();
            for (int i=0; i<courseSessionService.size(); i++)
            {
                CourseSession courseSession = (CourseSession) courseSessionService.get(i) ;
                String item = courseSession.getId().toString();
    %>
               <option for="courseSession" value=<%=item%>><%=courseSession%></option>
    <%
            }
    %>
            </select>
            <br>
            <br>
            
            <input type="submit" value="Valider"/>  
        </form>
        
    <%
        ClientService clientService = new ClientService();
        List<Client> listClient = clientService.listClient();
        
    %>
        <br>
        <h1>Liste des Clients</h1>
        <table>
        <tr>
            <td> ID </td>
            <td> LASTNAME </td>
            <td> FIRSTNAME </td>
            <td> ADDRESS </td>
            <td> EMAIL </td>
            <td> COURSE_SESSION_ID </td>
            <td> PHONE </td>
            </tr>
            
            <%for(Client c : listClient){%>
                <tr>
                <td><% out.println(c.getId()); %></td>
                <td><% out.println(c.getLastname()); %></td>
                <td><% out.println(c.getFirstname()); %></td>
                <td><% out.println(c.getAddress()); %></td>
                <td><% out.println(c.getEmail()); %></td>
                <td><% out.println(c.getCourseSession().getId()); %></td>
                <td><% out.println(c.getPhone()); %></td>
                </tr>
            <%}%>
            </table>
            </body>
            </html>
    </body>
</html>

