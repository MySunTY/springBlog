package com.example.BlogStart;

import com.example.BlogStart.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MainContoller {

    private UserService userService;

    @GetMapping("/main")
    public String mainPage(Model model){
        String title = "메인페이지";
        model.addAttribute("title",title);
        return "mainpage.html";
    }

    @GetMapping("/")
    public String login(Model model){
        String title = "로그인 페이지";
        model.addAttribute("title",title);
        return "loginpage.html";
    }

    @GetMapping("/register")
    public String register(Model model){
        String title ="회원가입 페이지";
        model.addAttribute("title",title);
        return "register.html";
    }




}
