package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;



@RestController
@RequestMapping("/posts")
public class PostsController {


    @Autowired
    private PostRepository postRepository;


    @Autowired
    private CommentRepository commentRepository;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }
    @GetMapping("")
    public List<Post> index() {
        return postRepository.findAll();
    }
    @GetMapping("/{id}")
    public Post show(@PathVariable("id") String id) {
        return postRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }
    @PutMapping("/{id}")
    public Post update(@PathVariable("id") String id, @RequestBody Post post) {
        var maybePost = postRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        maybePost.setTitle(post.getTitle());
        maybePost.setBody(post.getBody());
        postRepository.save(maybePost);
        return maybePost;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        postRepository.deleteById(Long.parseLong(id));
        commentRepository.deleteByPostId(Long.parseLong(id));
    }
}