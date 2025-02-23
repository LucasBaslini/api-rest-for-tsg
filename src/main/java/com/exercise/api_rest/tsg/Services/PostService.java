package com.exercise.api_rest.tsg.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.api_rest.tsg.Models.Post;
import com.exercise.api_rest.tsg.Repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return post;
    }

    public List<Post> getPostsByUserId(Integer userId) {
        return postRepository.findByUserId(userId);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Integer id, Post newData) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(newData.getTitle());
        post.setContent(newData.getContent());
        return postRepository.save(post);
    }

    public void deletePost(Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
    }
}