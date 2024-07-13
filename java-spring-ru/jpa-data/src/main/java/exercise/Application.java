package exercise;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
public class Application {


    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping("/people")
    public List<Person> index() {
        return repository.findAll();
    }

    @PostMapping("/people")
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        repository.save(person);
        return person;
    }

    @DeleteMapping("people/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(Long.parseLong(id));
    }

}
