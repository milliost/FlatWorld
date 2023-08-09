package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.ChatMessage;
import com.example.servingwebcontent.model.GameTable;
import com.example.servingwebcontent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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
    private GameTable gameTable;
    @GetMapping("/game")
    public String game() {
        if (gameTable==null){gameTable = new GameTable();}
        return "game";
    }
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
    @ResponseBody
    @GetMapping("/myName")
    public String myName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    @ResponseBody
    @PostMapping("/sit")
    public String sitDown1(@RequestParam int num) {
        gameTable.sitOnChair(num,getCurrentUser());
        return "Игрок " + getCurrentUser().getName() + " занял 1 место";
    }
    @ResponseBody
    @PostMapping("/start")
    public String start(){
        gameTable.startGame();
        return "start";
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return us.findByName(auth.getName());
    }
}
