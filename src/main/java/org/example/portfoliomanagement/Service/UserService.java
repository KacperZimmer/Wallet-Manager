package org.example.portfoliomanagement.Service;


import org.example.portfoliomanagement.Entity.User;
import org.example.portfoliomanagement.Repository.UserRepository;
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
