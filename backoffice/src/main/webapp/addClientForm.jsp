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
       <h1>Ajoutez un nouveau client : </h1>
       <div class="container">
            <div class="row">
  		<div class="col-md-6">
                         <div class="form-group">
                                <form action="/backoffice/addClient" method="POST">
                                    <label for="firstname">Firstname : </label>
                                    <input class="form-control" type="text" id="firstname" name="firstname" required/>
                                    <br>
                                    <br>

                                    <label for="lastname">Lastname : </label>
                                    <input class="form-control" type="text" id="lastname" name="lastname" required/>
                                    <br>
                                    <br>

                                    <label for="address">Address : </label>
                                    <input class="form-control" type="text" id="address" name="address" required/>
                                    <br>
                                    <br>

                                    <label for="phone">Phone : </label>
                                    <input class="form-control" type="text" id="phone" name="phone" required/>
                                    <br>
                                    <br>

                                    <label for="email">Email : </label>
                                    <input class="form-control" type="text" id="email" name="email" required/>
                                    <br>
                                    <br>

                                    <label for="courseSession">Course Session : </label>
                                    <select class="form-control" name="courseSession" id="courseSession">
                            <%
                                    CourseSessionService css = new CourseSessionService();
                                    List<CourseSession> courseSessionService = css.listCourseSession();
                                    for (int i=0; i<courseSessionService.size(); i++)
                                    {
                                        CourseSession courseSession = (CourseSession) courseSessionService.get(i) ;
                                        String item = courseSession.getId().toString();
                            %>
                                       <option for="courseSession" value=<%=item%>>courseSession.getId()</option>
                            <%
                                    }
                            %>
                                    </select>
                                    <br>

                                    <input class="btn btn-primary" type="submit" value="Valider"/>  
                                </form>
                        </div>
                  </div>
            </div>
        </div>

            </body>
            </html>
    </body>
</html>

