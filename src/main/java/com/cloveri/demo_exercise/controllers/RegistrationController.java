package com.cloveri.demo_exercise.controllers;

import com.cloveri.demo_exercise.repo.UserRepository;
import com.cloveri.demo_exercise.security.RegistrationForm;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    @ApiOperation(value = "Переход на страницу регистрации")
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    @ApiOperation(value = "Получение заполненной на странице регистрации формы и сохранение пользователя в БД")
    public String processRegistration(RegistrationForm form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }
}
