package com.exercise.api_rest.tsg.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.exercise.api_rest.tsg.Dto.CreatePostDTO;
import com.exercise.api_rest.tsg.Dto.UpdatePostDTO;
import com.exercise.api_rest.tsg.Models.Post;
import com.exercise.api_rest.tsg.Services.PostService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@Valid @RequestBody CreatePostDTO createPostDTO) {
        Post savedPost = postService.create(createPostDTO);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Post> updatePost(
            @PathVariable Integer id,
            @Valid @RequestBody UpdatePostDTO updatePostDTO) {
        return ResponseEntity.ok(postService.update(id, updatePostDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(postService.findByUser(userId));
    }
}
