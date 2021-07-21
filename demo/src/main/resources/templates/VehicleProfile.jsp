<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <link rel="stylesheet" href="/css/VehicleProfile.css">
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

  <!-- JavaScript Bundle with Popper -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</head>
<body><nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/showHomepage">Home <span class="sr-only"></span></a>
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
      <li class="nav-item">
        <a class="nav-link" id="logout" href="/login">Logout</a>
      </li>
    </ul>

  </div>
</nav>
<div class="body1"><br><br>

  <div class="card" style="width: 18rem;">
    <div class="card-body">
      <h5 class="card-title">MODIFICA TARGA VEICOLO</h5><hr>
      <div class="card">
        <div class="card-body" style="text-align:center;">
          VECCHIA TARGA: <b th:text="${oldTarga}"> </b>
        </div>

        <div class="mb-3">
          <button onclick="myFunction()" type="button" class="btn btn-danger">Cambia targa</button>
        </div>
      </div>
    </div>
  </div><br><br><br>

  <div id="myDIV">
    <h4>INSERISCI NUOVA TARGA</h4>
    <form th:action="@{/changeVehicleTarga/{vecchiaTarga}(vecchiaTarga = ${oldTarga})}" method="post">
      <input type="text" name="targa" class="form-control"  aria-describedby="emailHelp"><br>
      <button type="submit" class="btn btn-danger">Aggiorna</button>
    </form>
  </div>
</div>

<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
</script><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>
</body>
</html>