package org.example.walletmanagement.Controller;

import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainPageController {

    private final UserService userService;

    MainPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/homePage")
    public String homePage() {
        return "homePage";
    }


    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        this.userService.saveUser(user);
    }

}
