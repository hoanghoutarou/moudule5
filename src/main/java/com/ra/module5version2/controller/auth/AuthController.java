package com.ra.module5version2.controller.auth;


import com.ra.module5version2.model.entity.User;
import com.ra.module5version2.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class AuthController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/login")
//    public String Login() {
//        return "auth/login";
//    }
//
//    @GetMapping("/register")
//    public String register(Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "auth/register";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute("user") User user) {
//        userService.handleRegister(user);
//        return "redirect:/login";
//    }
}
