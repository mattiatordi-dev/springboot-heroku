<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="bean.Mezzo" %>
    <%@page import="bean.Utente" %>
    <%@page import="bean.Prenotazione" %>
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
.table1{
width:60%;
margin-left:auto;
margin-right:auto;
}
form{
text-align:center;
margin-left:auto;
margin-right:auto;
width: 25%;
height: 30%;
}
.body1{
background-color: #F0F8FF;
}
h2,h3{
text-align:center;
}
</style>
</head>
<body>

<jsp:include page="header.jsp" />
<div class="body1"><br>
<h3>CERCA PER UTENTE </h3><hr>

<form method="post">
<div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Cognome</label>
    <input id="campo" type="text" name="nome" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
   </div>
 <hr>
  <button type="submit" formaction="/Servlet-Jsp-Project/ViewBookingCustomer" class="btn btn-primary">Cerca</button><br><hr>
  </form>
<h2>PRENOTAZIONI</h2><br><hr>
<div class="table1">
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOME UTENTE</th>
      <th scope="col">COGNOME UTENTE</th>
      <th scope="col">MODELLO</th>
      <th scope="col">TARGA</th>
    </tr>
  </thead>
  <tbody>
    <%!List<Prenotazione> lista; %>
    <%
    
    lista = (List<Prenotazione>) request.getSession().getAttribute("listaPrenotazioni");
    for(Prenotazione p : lista) {
	%>	
    <tr>
    	<td><%=p.getId()%></td>
        <td><%=p.getUtente().getNome() %></td>
        <td><%=p.getUtente().getCognome() %></td>
        <td><%=p.getMezzo().getModello() %></td>
        <td><%=p.getMezzo().getTarga() %></td>
        </tr>
    <% }%> 
     </tbody>
</table>
</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>