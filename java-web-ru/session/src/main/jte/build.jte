@import exercise.dto.LoginPage
@param LoginPage page


@template.layout.page (

content = @`

    @if(page.getError() != null)
        <div class="alert alert-primary" role="alert">
            ${page.getError()}
        </div>
    @endif


    <form class="row g-3 needs-validation" action="/sessions" method="post">
        <div class="col-md-4">
            <label for="validationCustom01" class="form-label">First name</label>
            <input type="text" class="form-control" id="validationCustom01" value="${page.getName()}" required name="name">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-md-4">
            <label for="validationCustom02" class="form-label">Password</label>
            <input type="password" class="form-control" id="validationCustom02" required name="password">
            <div class="valid-feedback">
                Looks good!
            </div>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit form</button>
        </div>
    </form>
`
)