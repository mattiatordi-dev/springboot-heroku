<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
.table1{
width:60%;
margin-left:auto;
margin-right:auto;
}
.body1{
background-color: #F0F8FF;
}
h2{
text-align:center;
}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="body1"><br>
<h2>PARCO AUTO PRESENTE NELLA NOSTRA STRUTTURA</h2><br><hr>
<div class="table1">
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">TARGA</th>
      <th scope="col">CASA COSTRUTTRICE</th>
      <th scope="col">MODELLO</th>
      <th scope="col">ANNO IMMATRICOLAZIONE</th>
      <th scope="col">TIPOLOGIA</th>
    </tr>
  </thead>
  <tbody>
    <%!List<Mezzo> lista; %>
    <%
    
    lista = (List<Mezzo>) request.getSession().getAttribute("listaAuto");
    for(Mezzo mezzo : lista) {
	%>	
    <tr>
    	<td><%=mezzo.getTarga() %></td>
        <td><%=mezzo.getCasa_costr() %></td>
        <td><%=mezzo.getModello() %></td>
        <td><%=mezzo.getAnno_imm() %></td>
        <td><%=mezzo.getTipologia() %></td>
        </tr>
    <% }%> 
     </tbody>
</table>
</div><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>