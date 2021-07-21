<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <link rel="stylesheet" href="css/Utility.css">
    <link rel="stylesheet" href="css/Users.css">
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
<h3 style="text-align:center;">LISTA UTENTI</h3><br><br>
<hr>

<table class="table table-striped" style="width:50%; margin-left:auto; margin-right:auto;">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Cognome</th>
        <th scope="col">Nome</th>
        <th scope="col">Data di nascita</th>
        <th scope="col">Admin</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="pers : ${lista}">
        <td th:text="${pers.id}"></td>
        <td th:text="${pers.cognome}"></td>
        <td th:text="${pers.nome}"></td>
        <td th:text="${{pers.getData_nascita()}}"></td>
        <td th:text="${pers.isRuolo_admin()}"></td>

    </tr>
    </tbody>
</table><br><hr>
<div class="divBook">
<h1>PRENOTA IL TUO MEZZO</h1><br>
<form th:action="@{/VehiclesUser/{cognome}(cognome = ${cognome})}">
    <button type="submit" class="btn btn-primary">Prenota</button>
</form>
</div>
</body>

