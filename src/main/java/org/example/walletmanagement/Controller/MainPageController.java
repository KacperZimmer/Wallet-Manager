package org.example.walletmanagement.Controller;

import org.example.walletmanagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainPageController {



    @GetMapping("/")
    public String homePage(Principal principal, Model model) {

        boolean isLoggenIn = (principal != null);

        model.addAttribute("isLoggedIn", isLoggenIn);


        return "HomePage/homePage";
    }


//    @PostMapping("/create")
//    public void createUser(@RequestBody User user) {
//        this.userService.saveUser(user);
//    }

}
