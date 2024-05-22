package exercise;

import io.javalin.Javalin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var result = new ArrayList<Map<String, String>>();
            var start = page * per + 1 - per;
            for (var i = 0; i < per; i++) {
                result.add(USERS.get(start));
                start++;
            }
            ctx.json(result);
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
