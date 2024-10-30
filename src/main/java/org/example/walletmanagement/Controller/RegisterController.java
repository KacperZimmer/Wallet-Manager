package org.example.walletmanagement.Controller;
import org.example.walletmanagement.Service.UserService;
import org.springframework.ui.Model;
import org.example.walletmanagement.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService){

        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("user", new User());

        return "Register/registerForm";
    }

    @PostMapping("/register")
    public String register(User user) {
        System.out.println(user);
        this.userService.registerUser(user);

        return "redirect:/mainPage";
    }


}
