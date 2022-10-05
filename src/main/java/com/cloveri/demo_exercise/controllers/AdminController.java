package com.cloveri.demo_exercise.controllers;

import com.cloveri.demo_exercise.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Tag(name = "Кабинет администратора", description = "Управление таблицей пользователей (просмотр и удаление)")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    @Operation(summary = "Получение данных всех пользователей", description = "Позволяет получить данные всех пользователей и добавляет их на страницу")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    @Operation(summary = "Удаление пользователей", description = "Позволяет удалять пользователей")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action, Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
    @PostMapping()
    @Operation(summary = "Назначение ролей пользователей", description = "Позволяет назначить уровень доступа пользователей (пользователь с уровнем OPERATOR может изменять описание маршрута)")
    public void roleUser() {
        System.out.println("Назначение ролей");
    }

    @GetMapping("/admin/gt/{userId}")
    @Operation(summary = "Выдача списка пользователей с ID > определённого значения", description = "Позволяет выдавать список пользователей с ID > значения переданного в конце строки адреса URL")
    public String gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

}
