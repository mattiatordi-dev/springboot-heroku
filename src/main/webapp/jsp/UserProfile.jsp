<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<style>
.card{
margin-left:auto;
margin-right:auto;
}
.card-title{
text-align:center;
}
#myDIV{
text-align:center;
margin-left:auto;
margin-right:auto;
width:30%;
display:none;
}
.mb-3{
margin-left:auto;
margin-right:auto;
}
#campo{
width:40%;
margin-left:auto;
margin-right:auto;
}
</style>
</head>
<body>
<jsp:include page="headerCustomer.jsp"/><br>

<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">PROFILO UTENTE</h5><hr>
    <div class="card">
  <div class="card-body">
    NOME: <b>  ${sessionScope.utente.nome}</b>
  </div>
  <div class="card-body">
    COGNOME:<b>  ${sessionScope.utente.cognome}</b> 
  </div>
  <div class="card-body">
    DATA NASCITA: <b>  ${sessionScope.utente.data_nascita}</b>
  </div>
  <div class="card-body">
    PASSWORD:  <strong>  ${sessionScope.utente.password}</strong>
  </div>
  <div class="mb-3">
  <button onclick="myFunction()" type="button" class="btn btn-danger">Cambia password</button>
  </div>
  </div>
  </div>
</div><br><br><br>

<div id="myDIV">
    <h4>IMMETTI NUOVA PASSWORD</h4>
    <form method="post">
    <input id="campo" type="text" name="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"><br>
    <button type="submit" class="btn btn-danger" formaction="/Servlet-Jsp-Project/ChangePasswordServlet?id=${utente.id}">Aggiorna</button>
    </form>
</div>

<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
</script>

</body>
</html>