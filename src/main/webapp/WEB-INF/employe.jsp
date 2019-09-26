<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>kanuni</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
     body{background-color: #f1f1f1;}
     .bslf{
    width: 350px;
  margin: 50px auto;
  padding: 25px 20px;
  background: #3b5998;
  box-shadow: 2px 2px 4px #ab8de0;
  border-radius: 5px;
  color: #fff;
     }
     .bslf h2{
  margin-top: 0px;
  margin-bottom: 15px;
  padding-bottom: 5px;
  border-radius: 10px;
  border: 1px solid #25055f;
     }
     .bslf a{color: #783ce2;}
     .bslf a:hover{
    text-decoration: none;
      color: #03A9F4;
     }
       .bslf1{
         width: 70%;
       margin: 50px auto;
       padding: 25px 20px;
       background: #3b5998;
       box-shadow: 2px 2px 4px #ab8de0;
       border-radius: 5px;
       color: #fff;
          }
          .bslf1 h2{
       margin-top: 0px;
       margin-bottom: 15px;
       padding-bottom: 5px;
       border-radius: 10px;
       border: 1px solid #25055f;
          }
          .bslf1 a{color:#03A9F4;}
          .bslf1 a:hover{
         text-decoration: none;
           color: #03A9F4;
          }
     .bslf .checkbox-inline{padding-top: 7px;}
  </style>
</head>
<body>
  <div class="bslf">
    <form action="" method="post">
      <h2 class="text-center">Ajouter Employe</h2>
            <div class="form-group">
                    <input type="text" class="form-control" name = "matricule" placeholder="Matrcule" required="required">
            </div>
            <div class="form-group">
                    <input type="text" class="form-control"  name = "nom" placeholder="Nom" required="required">
            </div>
            <div class="form-group">
                    <input type="date" class="form-control"  name = "datenaissance" placeholder="Date naissance" required="required">
            </div>
            <div class="form-group">
                    <input type="text" class="form-control"  name = "salaire" placeholder="Salaire" required="required">
            </div>
                      <div class="form-group ">
                           <div >
                              <select name="service" class="form-control" >
                              <option disabled selected>Choisir un service</option>
                                   <c:forEach items="${services}" var="s">
                                   <option value="${s.id}">${s.lib}</option>
                                   </c:forEach>
                              </select>
                           </div>
                      </div>
          <div class="form-group clearfix">
            <button  class="btn btn-default pull-left"><a href="${pageContext.request.contextPath}/employe?action=edit"></a>Annuler</button>
            <button type="submit" class="btn btn-primary pull-right">Se connecter</button>
          </div>
    </form>
    ${request.error}
  </div>

  <div class="bslf1">
  <h2 class="text-center">Listes des Employes</h2>
  <table class="table">
        <th>Matrcule</th>
        <th>Nom</th>
        <th>Date naissance</th>
        <th>Salaire</th>
        <th>Service</th>
        <th>Action</th>

        <c:forEach items="${employes}" var="em">
        <tr>
            <td>${em.matricule}</td>
            <td>${em.nom}</td>
            <td>${em.datenaissance}</td>
            <td>${em.salaire}</td>
            <td>${em.service.lib}</td>
            <td><a href="${pageContext.request.contextPath}/employe?action=edit?id=${em.id}" class="btn btn-default"><img src="https://img.icons8.com/ultraviolet/40/000000/edit-user-male.png">Editer</a></td>
        </tr>
        </c:forEach>
  </table>
  <div/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

