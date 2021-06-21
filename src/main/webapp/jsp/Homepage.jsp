<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.List"%>
    <%@page import="bean.Utente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="http://localhost:8080/css" type="text/css">
<link rel="stylesheet" href="Servlet-Jsp-Project/css/Homepage.css" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>HOME</title>
<style>
body{
background-repeat: no-repeat;
background-size:cover;
background-position: center;
background-attachment: fixed;
z-index:0;
}
.body1{
background-color: #F0F8FF;
}

form{
text-align:center;
margin-left:auto;
margin-right:auto;
width: 25%;
height: 30%;
}
.table1{
width:60%;
margin-left:auto;
margin-right:auto;
}
h3{
text-align:center;
}


</style>
</head>
<body>
<div class="body1">

<jsp:include page="header.jsp" /><br>
<h3>AGGIUNGI UTENTE </h3><hr>

<form method="post">
<div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nome</label>
    <input id="campo" type="text" name="nome" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Cognome</label>
    <input id="campo" name="cognome" type="text" class="form-control" id="exampleInputPassword1">
  </div>
  <label for="exampleInputPassword1" class="form-label">Data di nascita</label>
    <input id="campo" type="text" name="data_nasc" class="form-control" id="exampleInputPassword1">
  </div> <hr>
  <button type="submit" formaction="/Servlet-Jsp-Project/AddUserServlet" class="btn btn-primary">Aggiungi</button><br><hr>
  </form>
<h3>UTENTI REGISTRATI PRESSO LA NOSTRA STRUTTURA </h3><hr>
<div class="table1">
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">COGNOME</th>
      <th scope="col">DATA DI NASCITA</th>
      <th scope="col">NOME</th>
      <th scope="col">    </th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="user" items="${sessionScope.listaUtenti}">
    <tr>
        <td>${user.id}</td>
        <td>${user.cognome}</td>
        <td>${user.data_nascita}</td>
        <td>${user.nome}</td>
            <td><a href="http://localhost:8080/Servlet-Jsp-Project/BookServlet?id=${user.id}">Prenota mezzo</a>
            </td>
            </tr>
</c:forEach>
     </tbody>
</table>
  </div><br><br><br><br>
  </div>
</body>
</html>