package ru.rast.SB2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.rast.SB2.model.User;
import ru.rast.SB2.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String listUsers(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("listUsers", userList);
        return "users-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("user-create")
    public String createUser(User user) {
        if (user.getId() == null) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }

        return "redirect:/";
    }

    @GetMapping("/user-delete")
    public String deleteUser(Integer id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping(value = "/user-update")
    public String updateUserForm(Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping(value = "/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
