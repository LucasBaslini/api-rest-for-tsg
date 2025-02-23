package com.exercise.api_rest.tsg.Repository;

import com.exercise.api_rest.tsg.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
