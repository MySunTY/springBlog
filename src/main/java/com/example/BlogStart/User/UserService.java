package com.example.BlogStart.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void userRegister(String userId, String password, String email){
        User user = new User();
        user.setUser_id(userId);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        this.userRepository.save(user);

    }

}
