package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        app.post("/articles", ctx -> {
            var noValidTitle = ctx.formParam("title");
            var noValidContent = ctx.formParam("content");
            try {
                var title1 = ArticleRepository.getEntities().stream()
                        .filter(v -> v.getTitle().equals(noValidTitle))
                        .findFirst();
                var title = ctx.formParamAsClass("title", String.class)
                        .check(value -> title1.isEmpty(), "Статья с таким названием уже существует")
                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                        .get();
                var content = ctx.formParamAsClass("content", String.class)
                        .check(value -> value.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();
                Article article = new Article(title, content);
                ArticleRepository.save(article);
                ctx.redirect("/articles");
            } catch (ValidationException e) {
                var page = new BuildArticlePage(noValidTitle, noValidContent, e.getErrors());
                ctx.render("articles/build.jte", model("page", page));
            }
        });

        app.get("/articles/build", ctx -> {
            var page = new BuildArticlePage();
            ctx.render("articles/build.jte", model("page", page));
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
