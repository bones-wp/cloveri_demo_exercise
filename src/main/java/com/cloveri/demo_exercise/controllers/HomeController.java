package com.cloveri.demo_exercise.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    @ApiOperation(value = "Переход на главную страницу (/home)")
    public String home() {
        return "home";
    }
}