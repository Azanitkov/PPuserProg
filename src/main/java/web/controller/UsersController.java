package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    public UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/users/new";
    }

    @PostMapping("/new")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "/users/users";

    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser(long id,
                             @ModelAttribute("user") User updatedUser) {
        userService.updateUser(id, updatedUser);
        return "redirect:/users";
    }

    @PostMapping("/edit/form")
    public String editUserForm(@RequestParam("id") Long id,
                               Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/edit";
    }

}
