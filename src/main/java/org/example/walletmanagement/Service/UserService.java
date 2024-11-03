package org.example.walletmanagement.Service;


import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public void deleteUser(User user){
        this.userRepository.delete(user);
    }

    public void registerUser(User user){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        this.userRepository.save(user);
    }

    public User getUserByUsername(String username){

        return this.userRepository.findByUsername(username);
    }


}
