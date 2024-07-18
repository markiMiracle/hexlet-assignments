package exercise.daytime;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;



@RequestScope
@Component("night")
public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }
    @PostConstruct
    public void init() {
        System.out.println("Bean is initialized!");
    }
}
