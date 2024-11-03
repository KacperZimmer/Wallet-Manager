package org.example.walletmanagement.Service;

import org.example.walletmanagement.Entity.User;
import org.example.walletmanagement.Entity.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomMyUserDetailsService implements UserDetailsService {
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(this.userService.getUserByUsername(username) == null){
            throw new UsernameNotFoundException(username);
        }
        User user = userService.getUserByUsername(username);

        return new UserPrincipal(user);
    }
    CustomMyUserDetailsService(UserService userService) {
        this.userService = userService;
    }
}
