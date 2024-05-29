package exercise.controller;

import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionsController {

    public static void build(Context ctx) {
        var page = new LoginPage();
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> UsersRepository.findByName(value) != null, "Wrong username or password")
                    .get();
            var confirmPass = Security.encrypt(ctx.formParam("password"));
            boolean isValid = confirmPass.hashCode() == UsersRepository.findByName(name).getPassword().hashCode();
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> isValid, "Wrong username or password")
                    .get();
            ctx.sessionAttribute("name", name);
            ctx.redirect(NamedRoutes.rootPath());
        } catch (ValidationException e) {
            var noValidName = ctx.formParam("name");
            var page = new LoginPage(noValidName, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
            ctx.status(422);
        }
    }
    public static void delete(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
        ctx.status(302);
    }
}
