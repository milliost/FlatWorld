package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.games.flatWorld.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.Game;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.LobbyService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LobbyController {
    private UserService us;
    private LobbyService ls;
    private GameController gc;

    public LobbyController(UserService us, LobbyService ls){
        this.us = us;
        this.ls = ls;
    }

    @GetMapping("/game")
    public String game() {
        return "game";
    }

    @ResponseBody
    @GetMapping("/history")
    public String kek() {
        return ls.toString();
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage) {
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        chatMessage.setSender("Сервер");
        chatMessage.setContent(chatMessage.getSender()+": подключился к игре");
        return chatMessage;
    }

    @MessageMapping("/chat.history")
    @SendTo("/topic/public")
    public ChatMessage history(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.HISTORY);
        chatMessage.setSender("Server");
        chatMessage.setContent(ls.toString());
        return chatMessage;
    }

    @MessageMapping("/chat.start")
    @SendTo("/topic/public")
    public ChatMessage start(@Payload ChatMessage chatMessage) {
        Game game = new Game(ls.makeUserArrayForGame());
        gc = new GameController(game);
        return chatMessage;
    }
    @MessageMapping("/chat.sit")
    @SendTo("/topic/public")
    public ChatMessage sit(@Payload ChatMessage chatMessage) {

        User callingPlayer = us.findByName(chatMessage.getSender());
        int numOfChair = Integer.parseInt(chatMessage.getContent().replaceAll("[a-z]",""));

        ls.upChair(callingPlayer);
        ls.sitOnChair(numOfChair, callingPlayer);
        return chatMessage;
    }
}




