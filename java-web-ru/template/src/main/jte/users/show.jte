@import exercise.dto.users.UserPage
@param UserPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="show.css">
</head>
<body>
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