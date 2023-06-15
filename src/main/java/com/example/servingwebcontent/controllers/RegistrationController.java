package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.service.UserService;
import com.example.servingwebcontent.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public @ResponseBody String addNewUser (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String repeatPassword) {
        if(password.equals(repeatPassword)){
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userService.saveUser(n);
        return "redirect:/greeting";
        }
        else {
            return "registration";
        }
    }
    @GetMapping("/registration")
    public String registration(){
        return "/registration";
    }
}
