package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.posts.PostsPage;
import exercise.repository.PostRepository;

import io.javalin.http.Context;

public class PostsController {
    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var page = new PostsPage(posts, 1);
        ctx.render("index.jte", model("page", page));
    }

    public static void page(Context ctx) {
        Integer pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var page = new PostsPage(PostRepository.findAll(pageNumber, 5), pageNumber);
        ctx.render("posts/index.jte", model("page", page));
    }
}
