@import exercise.dto.users.UserPage
@import gg.jte.Content
@param UserPage page
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мой Сайт</title>
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
    <a href="/users">/users</a>
</div>
<h1>Данные о пользователе:</h1>
<table class="table">
    <tr>
        <td>id</td>
        <td>first_name</td>
        <td>last_name</td>
    </tr>
    <tr>
        <td>${page.getUser().getId()}</td>
        <td>${page.getUser().getFirstName()}</td>
        <td>${page.getUser().getLastName()}</td>
    </tr>
</table>
</body>
</html>