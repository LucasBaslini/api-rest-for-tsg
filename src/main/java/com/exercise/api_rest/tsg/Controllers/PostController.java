package com.exercise.api_rest.tsg.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.exercise.api_rest.tsg.Models.Post;
import com.exercise.api_rest.tsg.Services.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/list/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Integer userId) {
        
        return postService.getPostsByUserId(userId);
    }

    @GetMapping("/get/{id}")
    public Post getPostById(@PathVariable Integer id) {
        return postService.getPostById(id);
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/update/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
    }
}
