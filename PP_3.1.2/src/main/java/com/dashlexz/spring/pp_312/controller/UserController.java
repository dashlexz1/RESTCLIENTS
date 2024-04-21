package com.dashlexz.spring.pp_312.controller;

import com.dashlexz.spring.pp_312.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.dashlexz.spring.pp_312.models.User;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        logger.info("Получаем список всех пользователей");
        model.addAttribute("users", userService.listUsers());
        logger.info("Пользователи успешно получены {}", userService.listUsers().size());
        return "users";
    }
    @GetMapping("/new")
    public String createUserGet(@ModelAttribute("user") User user) {
        logger.info("GET запрос на создание нового пользователя");
        return "users";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        logger.info("POST запрос на создание пользователя: {}", user);
        userService.saveUser(user);
        logger.info("Пользователь {} успешно сохранен", user.getName());
        return "redirect:/users";
    }

    @GetMapping("/removeUser")
    public String removeUser(@RequestParam(value = "id") Long id) {
        logger.info("GET запрос на удаление пользователя: {}", id);
        userService.deleteById(id);
        logger.info("Пользователь {} успешно удален", id);
        return "users";
    }

    @GetMapping("/id")
    public String editUserGet(@RequestParam(value = "id") Long id, Model model) {
        logger.info("GET запрос на редактирование пользователя с id: {}", id);
        model.addAttribute("user", userService.getUser(id));
        logger.info("Пользователь получен {}", id);
        return "users";
    }

    @PostMapping("/id")
    public String postEditUserForm(@ModelAttribute("user") User user) {
        logger.info("POST запрос на редактирование пользователя: {}", user);
        userService.updateUser(user);
        logger.info("Пользователь с id: {} успешно обновлен", user.getId());
        return "redirect:/users";
    }
}


