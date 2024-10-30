package org.example.walletmanagement.Service;


import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }
}
