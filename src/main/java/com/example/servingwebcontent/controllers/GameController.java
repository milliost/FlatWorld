package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.game.GameTable;
import com.example.servingwebcontent.repository.UserRepository;
import com.example.servingwebcontent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class GameController {
    private UserService us;
    GameTable gameTable;
    @GetMapping("/game")
    public String game(Model model) {
        if (gameTable==null){gameTable = new GameTable();}
        gameTable.addUser(getCurrentUser());
        model.addAttribute("users", gameTable.getUsers());
        return "game";
    }
    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
    @ResponseBody
    @GetMapping("/myName")
    public String myName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    @ResponseBody
    @PostMapping("/sit1")
    public String sitDown1() {
        gameTable.sit(0,getCurrentUser());
        return "Игрок "+getCurrentUser().getName()+" занял 1 место";
    }
    @ResponseBody
    @PostMapping("/sit2")
    public String sitDown2() {
        gameTable.sit(1,getCurrentUser());
        return "Игрок "+getCurrentUser().getName()+" занял 2 место";
    }
    @ResponseBody
    @PostMapping("/sit3")
    public String sitDown3() {
        gameTable.sit(2,getCurrentUser());
        return "Игрок "+getCurrentUser().getName()+" занял 3 место";
    }
    @ResponseBody
    @PostMapping("/sit4")
    public String sitDown4() {
        gameTable.sit(3,getCurrentUser());
        return "Игрок "+getCurrentUser().getName()+" занял 4 место";
    }
    @ResponseBody
    @PostMapping("/ready")
    public String ready() {
        gameTable.setReady(getCurrentUser());
        return "Игрок "+getCurrentUser().getName()+" готов";
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return us.findByName(auth.getName());
    }
}