package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;

public class RootController {
    public static void index(Context ctx) {
        ctx.render("index.jte");
    }
    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            Post post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Пост не найден"));
            var page = new PostPage(post);
            ctx.render("posts/show.jte", model("page", page));
        } catch (NotFoundResponse e) {
            ctx.redirect(NamedRoutes.postsPath());
            ctx.status(404);
        }

    }
}
