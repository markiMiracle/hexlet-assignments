


@template.layout.page(
    content = @`
    <h1>Регистрация</h1>
    <form action="/users" method="post">
        <div>
            <label>
                Имя
                <input type="text" name="firstName"/>
            </label>
        </div>
        <div>
            <label>
                Фамилия
                <input type="text" name="lastName"/>
            </label>
        </div>
        <div>
            <label>
                Email
                <input type="email" name="email"/>
            </label>
        </div>
        <div>
            <label>
                Пароль
                <input type="text" name="password"/>
            </label>
        </div>
        <input type="submit" name="Зарегестрировать">
    </form>


`
)