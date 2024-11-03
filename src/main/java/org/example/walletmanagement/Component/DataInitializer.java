package org.example.walletmanagement.Component;

import org.example.walletmanagement.Entity.Role;
import org.example.walletmanagement.Service.RoleService;
import org.springframework.boot.CommandLineRunner;

public class DataInitializer implements CommandLineRunner {

    RoleService roleService;

    DataInitializer(RoleService roleService) {
        this.roleService = roleService;
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
