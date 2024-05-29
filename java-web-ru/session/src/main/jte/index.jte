@import exercise.util.NamedRoutes
@import exercise.dto.MainPage
@param MainPage page


@template.layout.page (

content = @`

    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif
    @if(page.getName() != null)
        <h1>
            ${page.getName()}
        </h1>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Выйти</button>
            </div>
        </form>
    @endif
    `
)