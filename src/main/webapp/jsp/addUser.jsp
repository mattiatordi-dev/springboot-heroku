<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Set" %>
    <%@page import="bean.Prenotazione" %>
    <%@page import="bean.Utente" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Homepage.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
form{
text-align:center;
margin-left:auto;
margin-right:auto;
width: 25%;
height: 30%;
}
</style>

</head>
<body>
<jsp:include page="header.jsp" /><br>

<%
Set<Prenotazione> lista = (HashSet<Prenotazione>) request.getSession().getAttribute("listaPrenotazioni");
request.getSession().setAttribute("lista", lista);
Utente utente = (Utente) request.getSession().getAttribute("Utente");
request.getSession().setAttribute("utente", utente);

%>
<%=lista %>
<%=utente %>

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
  <label for="exampleInputPassword1" class="form-label">Targa auto</label>
    <input id="campo" type="text" name="targa" class="form-control" id="exampleInputPassword1">
  </div>
  <label for="exampleInputPassword1" class="form-label">Modello auto</label>
    <input id="campo" type="text" name="modello" class="form-control" id="exampleInputPassword1">
  </div>
  <label for="exampleInputPassword1" class="form-label">Casa costruttrice auto</label>
    <input id="campo" type="text" name="casa_costr" class="form-control" id="exampleInputPassword1">
  </div>
  <label for="exampleInputPassword1" class="form-label">Tipologia</label>
    <input id="campo" type="text" name="tipologia" class="form-control" id="exampleInputPassword1">
  </div>
  <label for="exampleInputPassword1" class="form-label">Anno di immatricolazione auto</label>
    <input id="campo" type="number" name="anno_imm" class="form-control" id="exampleInputPassword1">
  </div><br>
  <button type="submit" formaction="/Servlet-Jsp-Project/AddUserServlet" class="btn btn-primary">Aggiungi</button>
  <input type="submit" formaction="/Servlet-Jsp-Project/insertAndViewDbServlet" class="btn btn-primary" value="Aggiorna DB">
</form>

<%
request.setAttribute("lista", lista);
request.setAttribute("utente", utente);		  
    		
    		
%>


</body>
</html>