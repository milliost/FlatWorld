package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping("/game")
    public static String greeting() {

        return "game";
    }
}