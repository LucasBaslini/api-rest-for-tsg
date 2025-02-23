package com.exercise.api_rest.tsg.Repository;

import com.exercise.api_rest.tsg.Models.Post;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
}
