package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;



@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();



    @GetMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index(@PathVariable String id) {
        var maybePost = posts.stream()
                .filter(entity -> Integer.parseInt(id) == entity.getUserId())
                .toList();
        return maybePost;
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post, @PathVariable String id) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);

        return post;
    }
}
