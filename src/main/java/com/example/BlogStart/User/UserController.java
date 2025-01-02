package com.example.BlogStart.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String userId, @RequestParam String password ,
                           @RequestParam String email){
        this.userService.userRegister(userId, password, email);
        System.out.println(userId);
        System.out.println(password);
        System.out.println(email);
        return "redirect:/";
    }


}
