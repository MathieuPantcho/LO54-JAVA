<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.utbm.ecole.core.service.LocationService" %>
<%@page import="fr.utbm.ecole.core.entity.Location" %>
<%@page import="java.util.List" %>
<% LocationService locationService = new LocationService() ; %>
<% List<Location> listLocation = locationService.listLocation(); %>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestion des locations</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <a href="/backoffice">Retour accueil</a>
         <h1>Ajoutez une nouvelle location: </h1>
        <form action="/backoffice/addlocation" method="POST">
            <label for="city">Titre du City : </label>
            <input type="text" id="city" name="city" minlength="3" required/>
            <br>
            
            <input type="submit" value="Valider"/>            
        </form>
        <h1>Liste des Locations </h1>
        <% for(Location l : listLocation){ %>
              <li> <% out.println(l.getId());%> : <% out.println(l.getCity());%> </li>
        <% }%>
    </body>
</html>
