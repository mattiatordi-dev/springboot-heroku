<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.body1{
background-color: #F0F8FF;
}
.card{
width:60%;
margin-left:auto;
margin-right:auto;
}
</style>
<%
LocalDate data = LocalDate.now();
String data1 = String.valueOf(data);
%>
</head>
<body>
<div class="body1">

<jsp:include page="header.jsp" /><br>

<div class="card text-center">
  <div class="card-header">
    CANCELLAZIONE PRENOTAZIONE
  </div>
  <div class="card-body">
    <h5 class="card-title">CANCELLAZIONE AVVENUTA CON SUCCESSO</h5>
    <p class="card-text">${sessionScope.prenotazione.id}  ${sessionScope.prenotazione.utente.cognome}  -  ${sessionScope.prenotazione.mezzo.modello}
      ${sessionScope.prenotazione.mezzo.targa}
     </p>
    <a href="http://localhost:8080/Servlet-Jsp-Project/jsp/HomepageCustomer.jsp" class="btn btn-primary">Torna alla Homepage</a>
  </div>
  <div class="card-footer text-muted">
    <%=data1 %>
  </div>
</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>