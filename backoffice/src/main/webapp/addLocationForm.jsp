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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="margin: 1em">
       
        <a href="/backoffice" class="btn btn-primary"  role="button">Retour accueil</a>
        <hr>         
        <h1>Ajoutez une nouvelle location: </h1>
        <div class="container">
        <div class="row">
        <div class="col-md-6">
        <div class="form-group">
        <form action="/backoffice/addlocation" method="POST">
            <label for="city">Titre du City : </label>
            <input type="text" id="city" name="city" minlength="3" required class="form-control"/>
            <input type="submit" class="btn btn-primary" value="Valider"/>            
        </form>
        </div>
        </div>
        </div>
        </div>
        <hr>
        <h1>Liste des Locations </h1>
         <table  class="table">
            <tr class="table-primary">
                  <td class="table-primary">ID</td>
                  <td class="table-primary">City</td>
            </tr>
            <% for(Location l : listLocation){ %>
            <tr class="table-primary">

                 <td class="table-primary"><% out.println(l.getId());%></td>
                 <td class="table-primary"> <% out.println(l.getCity());%></td>

            </tr>
            <% }%>
        </table>
    </body>
</html>
