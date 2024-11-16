package org.example.walletmanagement.Component;

import org.example.walletmanagement.Entity.Role;
import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Service.ExpenseService;
import org.example.walletmanagement.Service.RoleService;
import org.example.walletmanagement.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    RoleService roleService;
    UserService userService;
    ExpenseService expenseService;


    DataInitializer(RoleService roleService, UserService userService, ExpenseService expenseService) {
        this.roleService = roleService;
        this.userService = userService;
        this.expenseService = expenseService;
    }

    @Override
    public void run(String... args) throws Exception {



        Role roleUser = new Role();
        Role roleAdmin = new Role();
        roleUser.setName("ROLE_USER");
        roleAdmin.setName("ROLE_ADMIN");

        this.roleService.saveRole(roleUser);
        this.roleService.saveRole(roleAdmin);




    }
}
