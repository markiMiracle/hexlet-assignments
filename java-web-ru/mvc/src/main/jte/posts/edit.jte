@import exercise.dto.posts.EditPostPage
@param EditPostPage page


@template.layout.page (
    content = @`

    @if(page.getErrors() != null)
        <ul>
            @for(var validator: page.getErrors().values())
                @for(var error: validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif

    <div class="mx-auto p-4 py-md-5">
    <form action="/posts/${page.getId()}" method="post">
        <div>
            <label>
                Название
                <input type="text" name="name" value="${page.getName()}" />
            </label>
        </div>
        <div>
            <label>
                Содержание
                <textarea class="form-control" rows="20" cols="70" type="text" name="body">${page.getBody()}</textarea>
            </label>
        </div>
        <div>
            <input type="submit" value="Редактировать" />
        </div>
    </form>
    </div>
`
)
