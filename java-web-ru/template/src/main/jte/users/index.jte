@import exercise.dto.users.UsersPage
@param UsersPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
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