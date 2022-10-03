package com.cloveri.demo_exercise.repo;

import com.cloveri.demo_exercise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
