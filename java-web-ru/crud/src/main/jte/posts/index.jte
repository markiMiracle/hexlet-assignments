@import exercise.dto.posts.PostsPage
@param PostsPage page


@template.layout.page (
    content = @`

    @if(page.getPosts().isEmpty())
        <h1>Пока не добавлено ни одного поста</h1>
    @endif

    <ul>
        @for(var entity: page.getPosts())
            <li><a href="/posts/${entity.getId()}">${entity.getName()}</a></li>
        @endfor
    </ul>

    <nav class="navbar">
        <div class="menu">
            <a href="/posts?page=${page.getPageNumber() - 1}">Предыдущая</a>
        </div>
        <div class="menu">
            <a href="/posts?page=${page.getPageNumber() + 1}">Следующа</a>
        </div>
    </nav>

`
)
