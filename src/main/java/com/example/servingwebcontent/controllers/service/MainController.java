package com.example.servingwebcontent.controllers.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/game")
  public String game() {
    return "game";
  }
}
