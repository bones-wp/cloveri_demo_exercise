package com.cloveri.demo_exercise.repo;

import com.cloveri.demo_exercise.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
