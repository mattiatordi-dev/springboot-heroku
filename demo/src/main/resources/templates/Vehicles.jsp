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
        <a class="nav-link" href="#">Mezzi</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Books">Prenotazioni</a>
      </li>
    </ul>

  </div>
</nav><br>
<h3 style="text-align:center;">LISTA VEICOLI</h3><br><hr><br>
<div class="mb-3" style="text-align:center;">
  <button onclick="myFunction()" type="button" class="btn btn-danger">Ricerca per modello</button><br>
</div><hr>
<form th:action="@{/searchVehicles}" method="get" id="myDIV" style="margin-left:auto; margin-right:auto;text-align:center;width:20%;display:none;">
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
    <th scope="col">Modello</th>
    <th scope="col">Casa costruttrice</th>
    <th scope="col">Tipologia</th>
    <th scope="col">Targa</th>
    <th scope="col">Anno di immatricolazione</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="auto : ${lista}">
    <td th:text="${auto.id}"></td>
    <td th:text="${auto.modello}"></td>
    <td th:text="${auto.getCasa_costr()}"></td>
    <td th:text="${auto.tipologia}"></td>
    <td th:text="${auto.targa}"></td>
    <td th:text="${auto.getAnno_imm()}"></td>
    <td>
      <a th:href="@{/modified/{targa}(targa = ${auto.targa})}">
        Cambia targa
      </a>
    </td>
    <div th:if="${cognome != null}">
    <td>
      <a th:href="@{/bookVehicleAtUser/{cognome}/vehicle/{targa}(cognome = ${cognome},targa = ${auto.targa})}">
        <b>Prenota mezzo</b>
      </a>
    </td>
    </div>
  </tr>
  </tbody>
</table><br><hr>
<div class="mb-3" style="text-align:center;">
  <button onclick="myFunction1()" type="button" class="btn btn-danger">Aggiungi veicolo</button><br>
</div><hr>
<form th:action="@{/addVehicle}" method="post" id="myDIV1" style="margin-left:auto; margin-right:auto;text-align:center;width:20%;display:none;">
  <div class="form-group">
    <label for="exampleInputEmail1">Modello</label>
    <input type="text" class="form-control" name="modello" aria-describedby="emailHelp" placeholder="Enter name">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Casa costruttrice</label>
    <input type="text" class="form-control" name="casaCostr" aria-describedby="emailHelp" placeholder="Enter surname">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Tipologia</label>
    <input type="text" class="form-control" name="tipologia" aria-describedby="emailHelp" placeholder="Enter date of birth">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Targa</label>
    <input type="text" class="form-control" name="targa" aria-describedby="emailHelp" placeholder="Enter password">
  </div><br>
  <div class="form-group">
    <label for="exampleInputEmail1">Anno di immatricolazione</label>
    <input type="number" class="form-control" name="annoImm" aria-describedby="emailHelp" placeholder="Enter password">
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