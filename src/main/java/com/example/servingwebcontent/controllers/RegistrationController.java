package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/registration")
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String registration(){
        return "registration";
    }
    @PostMapping()
    public String addNewUser (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String repeatPassword) {
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
    @ResponseBody
    @GetMapping("/checkName")
    public boolean checkName(@RequestParam(name = "name", required = true) String name){
        return userService.findByName(name) != null;
    }
    @ResponseBody
    @GetMapping("/checkEmail")
    public boolean checkEmail(@RequestParam(name = "email", required = true) String email){
        return userService.findUserByEmail(email) != null;
    }
}
