package org.example.walletmanagement.Service;

import org.example.walletmanagement.Entity.Role;
import org.example.walletmanagement.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public void saveRole(Role role){
        this.roleRepository.save(role);
    }
    public void createRole(Role role,String name){
        role.setName(name);
        this.roleRepository.save(role);
    }

}
