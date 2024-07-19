package exercise.controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN

// END
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;

    private Task task;

    @BeforeEach
    public void setUp() {
         task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.pokemon().name())
                .supply(Select.field(Task::getDescription), () -> faker.text().text(15))
                .create();
    }


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    @Test
    public void testShow() throws Exception {
        taskRepository.save(task);
        var request = get("/tasks/" + task.getId());
        mockMvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void createTest() throws Exception {
        var requset = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(task));

        mockMvc.perform(requset)
                .andExpect(status().isCreated());
    }

    @Test
    public void updateTest() throws Exception {
        taskRepository.save(task);

        var data = new HashMap<>();
        data.put("description", "ya lublu kotikov!");


        var request = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        var expectedTask = taskRepository.findById(task.getId());
        assertThat(expectedTask.get().getDescription()).isEqualTo("ya lublu kotikov!");
    }

    @Test
    public void deleteTest() throws Exception {
        taskRepository.save(task);

        var request = delete("/tasks/" + task.getId());

        mockMvc.perform(request)
                .andExpect(status().isOk());

        assertThat(taskRepository.findById(task.getId())).isEmpty();
    }
}
