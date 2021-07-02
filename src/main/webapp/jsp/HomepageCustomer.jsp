<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
         <%@page import="bean.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h3{
text-align:center;
}
.table1{
width:60%;
margin-left:auto;
margin-right:auto;
}
.body1{
background-color: #F0F8FF;
}
</style>
<%
Utente u = (Utente) request.getSession().getAttribute("utente");
request.getSession().setAttribute("utente", u);
%>
</head>
<body>

<jsp:include page="headerCustomer.jsp"/>
<div class="body1"><br>
<h3>PRENOTAZIONI DEL TUO PROFILO</h3><hr>
<div class="table1">
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID PRENOTAZIONE</th>
      <th scope="col">ID UTENTE</th>
      <th scope="col">COGNOME</th>
      <th scope="col">ID MEZZO</th>
      <th scope="col">MODELLO</th>
      <th scope="col">CASA COSTRUTTRICE</th>
      <th scope="col">TARGA</th>
      <th scope="col">    </th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="prenotazione" items="${sessionScope.prenotazioni}">
    <tr>
        <td>${prenotazione.id}</td>
        <td>${prenotazione.utente.id}</td>
        <td>${prenotazione.utente.cognome}</td>
        <td>${prenotazione.mezzo.id}</td>
        <td>${prenotazione.mezzo.modello}</td>
        <td>${prenotazione.mezzo.getCasa_costr()}</td>
        <td>${prenotazione.mezzo.targa}</td>
            <td><a href="http://localhost:8080/Servlet-Jsp-Project/DeleteBookingCustomerServlet?id=${prenotazione.id}">Cancella prenotazione</a>
            </td>
            </tr>
</c:forEach>
     </tbody>
</table>
  </div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  </div>
</body>
</html>