package com.cloveri.demo_exercise.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeDescriptionController {
    @GetMapping("/change_description_route")
    @ApiOperation(value = "Переход на страницу изменения описания маршрута")
    public String home() {
        return "change_description_route";
    }
}
