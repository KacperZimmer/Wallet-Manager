package org.example.portfoliomanagement.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.portfoliomanagement.Entity.User;
import org.example.portfoliomanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
