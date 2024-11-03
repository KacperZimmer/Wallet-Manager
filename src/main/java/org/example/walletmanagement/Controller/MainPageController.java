package org.example.walletmanagement.Controller;

import org.example.walletmanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {



    @GetMapping("/")
    public String homePage() {
        return "HomePage/homePage";
    }


//    @PostMapping("/create")
//    public void createUser(@RequestBody User user) {
//        this.userService.saveUser(user);
//    }

}
