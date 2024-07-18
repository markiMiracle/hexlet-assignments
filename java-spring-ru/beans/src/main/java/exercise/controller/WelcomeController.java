package exercise.controller;

import exercise.Application;
import exercise.daytime.Day;
import exercise.daytime.Daytime;
import exercise.daytime.Night;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;


@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String index() {
        var hour = LocalDateTime.now().getHour();
        String time = hour >= 6 && hour <= 22 ? Application.getDay().getName()
                : Application.getNight().getName();
        return "It is " + time + "! Welcome to Spring!";
    }
}
