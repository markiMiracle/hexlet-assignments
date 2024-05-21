package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {
        var mapper = new ObjectMapper();
        var app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());
        app.get("/phones", ctx -> ctx.result(mapper.writeValueAsString(Data.getPhones())));
        app.get("/domains", ctx -> ctx.result(mapper.writeValueAsString(Data.getDomains())));
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
