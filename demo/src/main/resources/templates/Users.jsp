<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
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
        <a class="nav-link" href="#">Home <span class="sr-only"></span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Users">Utenti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Vehicles">Mezzi</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Books">Prenotazioni</a>
      </li>
    </ul>

  </div>
</nav><br>
<h3 style="text-align:center;">LISTA CLIENTI</h3><br><hr><br>
<div class="mb-3" style="text-align:center;">
  <button onclick="myFunction()" type="button" class="btn btn-danger">Ricerca per cognome</button><br>
</div><hr>
<form th:action="@{/searchUser}" method="get" id="myDIV" style="margin-left:auto; margin-right:auto;text-align:center;width:20%;display:none;">
  <div class="form-group">
    <label for="exampleInputEmail1">Search</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name" aria-describedby="emailHelp" placeholder="Enter name">
  </div><br>
  <button type="submit" class="btn btn-danger">Search</button>
</form><br>

<table class="table table-striped" style="width:50%; margin-left:auto; margin-right:auto;">
  <thead>
  <tr>
    <th scope="col">ID</th>
    <th scope="col">Cognome</th>
    <th scope="col">Nome</th>
    <th scope="col">Data di nascita</th>
    <th scope="col">Password</th>
    <th scope="col">Admin</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="pers : ${lista}">
    <td th:text="${pers.id}"></td>
    <td th:text="${pers.cognome}"></td>
    <td th:text="${pers.nome}"></td>
    <td th:text="${{pers.getData_nascita()}}"></td>
    <td th:text="${pers.password}"></td>
    <td th:text="${pers.isRuolo_admin()}"></td>
    <td>
      <a th:href="@{/prova/{isAdmin}/lastname/{cognome}(isAdmin = ${pers.isRuolo_admin()},cognome = ${pers.cognome})}">
       Rendi ADMIN
      </a>
    </td>
    <td>
      <a th:href="@{/register}">
        Modifica dati
      </a>
    </td>
    <td>
      <a th:href="@{/bookVehicle/{cognome}(cognome = ${pers.cognome})}">
        <b>Prenota mezzo</b>
      </a>
    </td>
  </tr>
  </tbody>
</table><br><hr>
<div class="mb-3" style="text-align:center;">
  <button onclick="myFunction1()" type="button" class="btn btn-danger">Aggiungi utente</button><br>
</div><hr>
<form th:action="@{/addUser}" method="post" id="myDIV1" style="margin-left:auto; margin-right:auto;text-align:center;width:20%;display:none;">
  <div class="form-group">
    <label for="exampleInputEmail1">Nome</label>
    <input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="Enter name">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Cognome</label>
    <input type="text" class="form-control" name="surname" aria-describedby="emailHelp" placeholder="Enter surname">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Data di nascita</label>
    <input type="text" class="form-control" name="date" aria-describedby="emailHelp" placeholder="Enter date of birth">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Password</label>
    <input type="text" class="form-control" name="password" aria-describedby="emailHelp" placeholder="Enter password">
  </div><br>
  <button type="submit" class="btn btn-danger">Aggiungi</button>
</form><br><br>



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