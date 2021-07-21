<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
  <link rel="stylesheet" href="/css/Utility.css">
  <link rel="stylesheet" href="css/Utility.css">
  <meta charset="UTF-8">
  <title>Title</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body><nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/showHomepageUser">Home <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/showUserPage">Utenti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/showVehiclesPage">Mezzi</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/showBookingPage">Prenotazioni</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" id="logout" href="/login">Logout</a>
      </li>
    </ul>

  </div>
</nav><br>
<h3 style="text-align:center;">LISTA PRENOTAZIONI</h3><br><br>
<hr>
<form th:action="@{/searchBook}" method="get" id="myDIV" style="margin-left:auto; margin-right:auto;text-align:center;width:10%;display:none;">
  <div class="form-group">
    <label for="exampleInputEmail1">Search</label>
    <input type="number" style="text-align: center" class="form-control" id="exampleInputEmail1" name="data" aria-describedby="emailHelp" placeholder="Enter an year">
  </div><br>
  <button type="submit" class="btn btn-danger">Search</button>
</form><br>

<table class="table table-striped" style="width:50%; margin-left:auto; margin-right:auto;">
  <thead>
  <tr>
    <th scope="col">ID</th>
    <th scope="col">Cognome</th>
    <th scope="col">Nome</th>
    <th scope="col">Modello</th>
    <th scope="col">Casa costruttrice</th>
    <th scope="col">Targa</th>
    <th scope="col">Data prenotazione</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="pren : ${lista}">
    <td th:text="${pren.id}"></td>
    <td th:text="${pren.utente.cognome}"></td>
    <td th:text="${pren.utente.nome}"></td>
    <td th:text="${pren.mezzo.modello}"></td>
    <td th:text="${pren.mezzo.getCasa_costr()}"></td>
    <td th:text="${pren.mezzo.targa}"></td>
    <td th:text="${pren.getData_prenotazione()}"></td>
    <td>
      <a th:href="@{/deleteUser/{id}/user/{utente}(id = ${pren.id},utente = ${pren.utente.cognome})}">
        Cancella prenotazione
      </a>
    </td>
  </tr>
  </tbody>
</table><br><hr>
<br>



<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

function myFunction1() {
  var x = document.getElementById("myDIV1");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
</script>
</body>
</html>