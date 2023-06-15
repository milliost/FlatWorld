package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @GetMapping("/login")
    public String login(@RequestParam(name = "param", required = false, defaultValue = "")String name, Model model) {
        model.addAttribute(name);
        return "login";
    }
}
