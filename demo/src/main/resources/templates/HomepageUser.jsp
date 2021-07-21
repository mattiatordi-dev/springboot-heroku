<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <link rel="stylesheet" href="css/Homepage.css">
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
</nav>
<div th:if="${cognome != null}">
<div class="userWelcome">
    <h3>Benvenuto utente:  <b th:text= "${cognome}" ></b> </h3>
</div>
</div>
<div class="central">
    <div class="container text-center">
        <h1 class="display-1">Desideri un auto da noleggiare?</h1>
        <div class="shadow-lg p-3 mb-5 bg-transparent rounded">
            <p class="lead"><b><i><h4>Vieni a scoprire il parco auto di <b>"Rental car ROMA"</b></h4>
            </i>
            </b>
            </p>
        </div>
    </div>
    <div class="loading">
        <div class="d-flex">
            <strong>Sito in continuo sviluppo...</strong>
            <div class="spinner-border ms-5" role="status" aria-hidden="true"></div>
        </div>
    </div>
</div>


</body>
</html>