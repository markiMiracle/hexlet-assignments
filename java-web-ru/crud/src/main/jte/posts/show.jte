@import exercise.dto.posts.PostPage
@param PostPage page


@template.layout.page (
    content = @`
    <h1>
        ${page.getPost().getName()}
    </h1>

    <h3>
        ${page.getPost().getBody()}
    </h3>
`
)
