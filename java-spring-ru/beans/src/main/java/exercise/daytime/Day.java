package exercise.daytime;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;






@RequestScope
@Component("day")
public class Day implements Daytime {
    private String name = "day";

    public String getName() {
        return name;
    }
    @PostConstruct
    public void init() {
        System.out.println("Bean is initialized!");
    }
}
