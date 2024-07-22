package exercise.controller;

import java.util.List;
import java.util.stream.Collectors;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.model.Task;
import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper mapper;


    @GetMapping
    public List<TaskDTO> index() {
        return taskRepository.findAll().stream()
                .map(task -> mapper.map(task))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskDTO show(@PathVariable("id") String id) {
        return mapper.map(taskRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateDTO createDto) {
        Task task = mapper.map(createDto);
        taskRepository.save(task);
        return mapper.map(task);
    }

    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable("id") String id, @RequestBody TaskUpdateDTO updateDto) {
        User assignee = userRepository.findById(updateDto.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + updateDto.getAssigneeId() + " not found"));

        var task = taskRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        mapper.update(updateDto, task);
        assignee.addTask(task);
        taskRepository.save(task);
        userRepository.save(assignee);
        return mapper.map(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        var task = taskRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));
        taskRepository.deleteById(Long.parseLong(id));

        User assignee = task.getAssignee();
        assignee.removeTask(task);
        userRepository.save(assignee);
    }
}
