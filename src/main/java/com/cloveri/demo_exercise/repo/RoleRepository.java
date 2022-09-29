package com.cloveri.demo_exercise.repo;

import com.cloveri.demo_exercise.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
