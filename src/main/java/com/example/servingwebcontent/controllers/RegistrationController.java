package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String addNewUser (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String repeatPassword,
            Model model) {
        if(password.equals(repeatPassword)){
        User n=new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userService.saveUser(n);
        System.out.println("User "+ name + " saved");
        return "redirect:/greeting";
        }
        else {
            return "redirect:/registration?error";
        }
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
}
