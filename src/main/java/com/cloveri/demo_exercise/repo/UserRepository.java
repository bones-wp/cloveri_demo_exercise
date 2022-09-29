package com.cloveri.demo_exercise.repo;

import com.cloveri.demo_exercise.security.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
