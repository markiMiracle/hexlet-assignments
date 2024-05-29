@import exercise.dto.posts.PostsPage
@param PostsPage page



@template.layout.page(
    content = @`

    <ul>
    @for(var post: page.getPosts())
        <li><a href="/posts/${post.getId()}">${post.getName()}</a></li>
    @endfor
    </ul>

 `,
    footer = @`
    @if(page.getFlash() != null)
        <div class="alert alert-primary" role="alert">
            ${page.getFlash()}
        </div>
    @endif
`
 )