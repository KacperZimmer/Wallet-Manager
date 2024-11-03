package org.example.walletmanagement.Repository;

import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
