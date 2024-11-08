package org.example.walletmanagement.Controller;
import org.example.walletmanagement.Entity.Role;
import org.example.walletmanagement.Service.RoleService;
import org.example.walletmanagement.Service.UserService;
import org.springframework.ui.Model;
import org.example.walletmanagement.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;
    private final RoleService roleService;

    public RegisterController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
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
        Role role = roleService.findByName("ROLE_ADMIN");
        user.getRoles().add(role);
        this.userService.registerUser(user);

        return "redirect:/login";
    }


}
