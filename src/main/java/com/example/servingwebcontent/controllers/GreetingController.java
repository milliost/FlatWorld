package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public static String greeting() {
        return "greeting";
    }
}