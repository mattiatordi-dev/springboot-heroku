<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
            crossorigin="anonymous"></script>
    <style>
        body{
            background: rgb(253,29,29);
            background: linear-gradient(174deg, rgba(253,29,29,1) 12%, rgba(51,36,225,1) 40%, rgba(199,181,43,1) 46%, rgba(237,73,33,1) 59%, rgba(176,216,38,1) 83%);
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
        }
    </style>
</head>
<body>
<div class="formDiv" style="margin-left:auto; margin-right:auto; text-align:center; width:20%; margin-top:10%;">
<form th:action="@{/login}" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Surname</label>
        <input type="text" class="form-control" id="exampleInputEmail1" name="username" aria-describedby="emailHelp" placeholder="Enter surname">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password">
    </div><br>
    <button type="submit" class="btn btn-primary">Submit</button>
</form><br><hr>

    <form action="/register">
            <button type="submit" class="btn btn-primary">Registrati</button>
    </form>


</div>
</body>
</html>