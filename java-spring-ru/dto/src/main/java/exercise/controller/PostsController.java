package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;



@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        return convertPostToDto(postRepository.findAll());
    }
    @GetMapping("/{id}")
    public PostDTO show(@PathVariable("id") String id) {
        return convertPostToDto(postRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found")));
    }

    private PostDTO convertPostToDto(Post post) {
        var postDto = new PostDTO();
        postDto.setId(post.getId());
        postDto.setBody(post.getBody());
        postDto.setTitle(post.getTitle());
        postDto.setComments(convertCommentsToDto(post.getId()));
        return postDto;
    }
    private List<PostDTO> convertPostToDto(List<Post> posts) {
        return posts.stream()
                .map(this::convertPostToDto)
                .collect(Collectors.toList());
    }
    private List<CommentDTO> convertCommentsToDto(Long id) {
        var comments = commentRepository.findByPostId(id);
        return comments.stream()
                .map(comment -> {
                    var dto = new CommentDTO();
                    dto.setId(comment.getId());
                    dto.setBody(comment.getBody());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}