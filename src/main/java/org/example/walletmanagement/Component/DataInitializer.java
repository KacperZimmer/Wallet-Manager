package org.example.walletmanagement.Component;

import org.example.walletmanagement.Entity.Role;
import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Service.RoleService;
import org.example.walletmanagement.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    RoleService roleService;
    UserService userService;

    DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = new Role();
        Role roleAdmin = new Role();
        roleUser.setName("ROLE_USER");
        roleAdmin.setName("ROLE_ADMIN");

        this.roleService.saveRole(roleUser);
        this.roleService.saveRole(roleAdmin);

        User user = new User();
        user.setUsername("admin");
        user.setPassword("$2a$12$Zd.WxxJl63MMsUjLlNbRIe71DyU9jn/nNBs6EOy0y2J/sIgUhQv62");
        user.setEmail("admin@admin.com");
        user.getRoles().add(roleAdmin);
        this.userService.saveUser(user);


    }
}
