
<!DOCTYPE HTML>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link rel="stylesheet" href="css/Utility.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
            crossorigin="anonymous"></script>
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
                <a class="nav-link" href="/Users">Utenti</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Vehicles">Mezzi</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Books">Prenotazioni</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/Login">Logout</a>
            </li>
        </ul>

    </div>
</nav><br><br><br><br>
<div class="formDiv" style="margin-left:auto; margin-right:auto; text-align:center; width:20%; margin-top:10%;">
<form action="#" th:action="@{/register}" th:object="${personForm}" method="post">

            <div class="form-group">
                <label><b>Nome</b></label>
            <td><input type="text" class="form-control" name="nome" th:field="*{nome}" th:errorClass="'error'"/></td>
            <p  th:if="${#fields.hasErrors('nome')}" th:class="${#fields.hasErrors('nome')}? error">
                Il nome deve essere minimo di due caratteri</p>
            </div><br>

            <div class="form-group">
                <label><b>Cognome</b></label>
            <td><input type="text" class="form-control" name="cognome" th:field="*{cognome}" /></td>
            <p  th:if="${#fields.hasErrors('cognome')}" th:class="${#fields.hasErrors('cognome')}? error">
                Il cognome deve essere minimo di due caratteri</p>
            </div><br>

            <div class="form-group">
                <label><b>Data di nascita</b></label>
            <td><input type="text" class="form-control" name="dataNascita" th:field="*{dataNascita}" /></td>
            <p  th:if="${#fields.hasErrors('dataNascita')}" th:class="${#fields.hasErrors('dataNascita')}? error">
                La data di nascita è obbligatoria</p>
            </div><br>

            <div class="form-group">
                <label><b>Password</b></label>
            <td><input type="password" class="form-control" name="password" th:field="*{password}" /></td>
            <p  th:if="${#fields.hasErrors('password')}" th:class="${#fields.hasErrors('password')}? error">
                La password deve essere compresa tra i 4 e 8 caratteri</p>
            </div><br>

            <button type="submit" class="btn btn-primary">Registrati</button></td><hr>
            <button type="submit" formaction="/updateUser" method="get" class="btn btn-primary">Aggiorna</button></td>

</form>
</div>
</body>
</html>