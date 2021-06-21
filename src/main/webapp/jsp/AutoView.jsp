<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.List"%>
    <%@page import="bean.Mezzo" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>RENTAL CAR</title>
<style>
body{
background-image: url(img/imgCar.jpg);
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

<%
int idUser = (int) request.getSession().getAttribute("idUser");
request.getSession().setAttribute("idUser", idUser);
%>
<h3>AGGIUNGI MEZZO</h3><hr>
<form method="post">
<div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Modello</label>
    <input id="campo" type="text" name="modello" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Casa costruttrice</label>
    <input id="campo" name="casa_costr" type="text" class="form-control" id="exampleInputPassword1">
  </div>
  <label for="exampleInputPassword1" class="form-label">Targa</label>
    <input id="campo" type="text" name="targa" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Anno di immatricolazione</label>
    <input id="campo" name="anno_imm" type="number" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Tipologia</label>
    <input id="campo" name="tipologia" type="text" class="form-control" id="exampleInputPassword1">
  </div> <hr>
  <button type="submit" formaction="/Servlet-Jsp-Project/BookServlet" class="btn btn-primary">Aggiungi</button><br><hr>
  </form>
<h3>UTENTI REGISTRATI PRESSO LA NOSTRA STRUTTURA </h3><hr>
<div class="table1">
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">MODELLO</th>
      <th scope="col">CASA COSTRUTTRICE</th>
      <th scope="col">TARGA</th>
      <th scope="col">ANNO IMMATRICOLAZIONE</th>
      <th scope="col">TIPOLOGIA</th>
      <th scope="col">    </th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="auto" items="${sessionScope.listaAuto}">
    <tr>
        <td>${auto.modello}</td>
        <td>${auto.casa_costr}</td>
        <td>${auto.targa}</td>
        <td>${auto.anno_imm}</td>
        <td>${auto.tipologia}</td>
            <td><a href="http://localhost:8080/Servlet-Jsp-Project/BookingServlet?id=${auto.id}">Prenota mezzo</a>
            </td>
        </form>
</c:forEach>
     </tbody>
</table>
</div><br><br><br><br><br>
</div>
</body>
</html>