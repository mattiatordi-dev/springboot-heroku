<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
            crossorigin="anonymous"></script>
</head>
<body><br><br><br><br><br>

<form action="#" th:action="@{/register}" th:object="${personForm}" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('companyName')}" th:errors="*{nome}"></p>
            <td><input type="text" name="nome" th:field="*{nome}" th:errorClass="'error'"/></td>
            <p class="alert alert-danger" th:if="${#fields.hasErrors('companyName')}" th:errors="*{nome}"></p>


        </tr>
        <tr>
            <td>Cognome:</td>
            <td><input type="text" name="cognome" th:field="*{cognome}" /></td>


        </tr>
        <tr>
            <td>Data di nascita:</td>
            <td><input type="text" name="dataNascita" th:field="*{dataNascita}" /></td>


        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" th:field="*{password}" /></td>


        </tr>
        <tr>
            <td><:button type="submit">Submit</:button></td>
        </tr>
    </table>
</form>
</body>
</html>