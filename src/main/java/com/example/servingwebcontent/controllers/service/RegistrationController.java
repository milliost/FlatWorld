package com.example.servingwebcontent.controllers.service;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.service.UserDTOService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/registration")
@Controller
@AllArgsConstructor
public class RegistrationController {

    private UserDTOService userService;

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
        n.setWins(0);
        userService.saveUser(n);
        System.out.println("User "+ name + " saved");
        return "redirect:/";
        }
        else {
            return "redirect:/registration?error";
        }
    }
    @ResponseBody
    @GetMapping("/checkName")
    public boolean checkName(@RequestParam(name = "name") String name){
        return userService.findByName(name) != null;
    }
    @ResponseBody
    @GetMapping("/checkEmail")
    public boolean checkEmail(@RequestParam(name = "email") String email){
        return userService.findUserByEmail(email) != null;
    }
}
