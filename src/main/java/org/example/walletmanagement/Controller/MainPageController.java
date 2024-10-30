package org.example.walletmanagement.Controller;

import org.example.walletmanagement.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final UserService userService;

    MainPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/homePage")
    public String homePage() {
        return "HomePage/homePage";
    }


//    @PostMapping("/create")
//    public void createUser(@RequestBody User user) {
//        this.userService.saveUser(user);
//    }

}
