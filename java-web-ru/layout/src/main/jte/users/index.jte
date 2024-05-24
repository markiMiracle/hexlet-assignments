@import exercise.dto.users.UsersPage
@param UsersPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .title {
            float: left;
            padding: 14px 20px;
            color: #f2f2f2;
            font-size: 18px;
        }
    </style>
</head>
<body>
<div class="navbar">
    <div class="title">Miracle Site</div>
    <a href="/">/Главная</a>
    <a href="users">/users</a>
</div>
<h1>Пользователи</h1>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : page.getUsers())
        <ul>
            <li><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></li>
        </ul>
    @endfor
@endif
</body>
</html>