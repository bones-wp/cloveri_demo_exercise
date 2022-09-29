package com.cloveri.demo_exercise.controllers;

import com.cloveri.demo_exercise.repo.UserRepository;
import com.cloveri.demo_exercise.security.Role;
import com.cloveri.demo_exercise.security.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/admin_req")

public class AdminRegController {

    UserRepository userRepository;

    @GetMapping
    @ApiOperation(value = "Переход на страницу администратора")
    public String home() {
        return "admin_reg";
    }

    @PostMapping
    @ApiOperation(value = "Назначение/изменение уровня доступа пользователей")
    public boolean enterRoleUSer (String username, String initRole) {
        User userFromDB = userRepository.findByUsername(username);

        if (userFromDB != null) {
            userFromDB.setRoles(Collections.singleton(new Role(1L, initRole)));
        }
        userRepository.save(userFromDB);
        return true;
    }

}
