package com.exercise.api_rest.tsg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.api_rest.tsg.Dto.CreatePostDTO;
import com.exercise.api_rest.tsg.Dto.UpdatePostDTO;
import com.exercise.api_rest.tsg.Models.Post;
import com.exercise.api_rest.tsg.Models.User;
import com.exercise.api_rest.tsg.Repository.PostRepository;
import com.exercise.api_rest.tsg.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Integer id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
    }

    public Post create(CreatePostDTO createPostDTO) {
        User user = userRepository.findById(createPostDTO.getUserId())
            .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + createPostDTO.getUserId()));

        Post post = new Post();
        post.setTitle(createPostDTO.getTitle());
        post.setContent(createPostDTO.getContent());
        post.setUser(user);
        post.setPublicationDate(LocalDateTime.now());

        return postRepository.save(post);
    }

    public Post update(Integer id, UpdatePostDTO updatePostDTO) {
        Post post = findById(id);
        post.setTitle(updatePostDTO.getTitle() != null ? updatePostDTO.getTitle() : post.getTitle());
        post.setContent(updatePostDTO.getContent() != null ? updatePostDTO.getContent() : post.getContent());
        
        return postRepository.save(post);
    }

    public void delete(Integer id) {
        Post post = findById(id);
        postRepository.delete(post);
    }

    public List<Post> findByUser(Integer userId) {
        return postRepository.findByUserId(userId);
    }
}