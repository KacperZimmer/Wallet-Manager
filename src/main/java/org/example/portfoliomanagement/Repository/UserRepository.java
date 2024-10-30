package org.example.portfoliomanagement.Repository;

import org.example.portfoliomanagement.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
