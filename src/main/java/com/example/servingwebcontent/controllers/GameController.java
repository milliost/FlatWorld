package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.ChatMessage;
import com.example.servingwebcontent.model.Game;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class GameController {
    private UserService us;
    private GameTable gameTable;
    private Game game;
    @GetMapping("/game")
    public String game() {
        return "game";
    }

    @ResponseBody
    @GetMapping("/kek")
    public String kek() {
        return gameTable.toString();
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

        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());

        for(int i=0; i<gameTable.getChairs().length;i++){ //проверка на юзера в массиве
            User usr = gameTable.getChairs()[i];
            if(usr!=null){
                if(chatMessage.getSender().equals(usr.toString())){return chatMessage;}
            }
        }

        for(int i=0; i<gameTable.getChairs().length;i++){ //если юзер не найден ему выделяется первое свободное место в массиве
            User usr = gameTable.getChairs()[i];
            if(usr==null){
                gameTable.sitOnChair(i,us.findByName(chatMessage.getSender()));
                return chatMessage;
            }
        }
        return chatMessage;
    }

    @MessageMapping("/chat.history")
    @SendTo("/topic/public")
    public ChatMessage history(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.HISTORY);
        chatMessage.setSender("Server");
        chatMessage.setContent(gameTable.toString());
        return chatMessage;
    }
    @ResponseBody
    @GetMapping("/myName")
    public String myName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    @MessageMapping("/chat.start")
    @SendTo("/topic/public")
    public ChatMessage start(@Payload ChatMessage chatMessage){
        game.start();
        chatMessage.setSender("server");
        chatMessage.setContent();
        return chatMessage;
    }
    @MessageMapping("/chat.chair")
    @SendTo("/topic/public")
    public ChatMessage sit2(@Payload ChatMessage chatMessage) {
        String[] buttons  = {"button1", "button2", "button3", "button4"};

        for(int i=0; i<gameTable.getChairs().length;i++){ //освободить стул
            User usr = gameTable.getChairs()[i];
            if(usr!=null){
                if(chatMessage.getSender().equals(usr.getName())){gameTable.upChair(i);}
            }
        }

        for(int i = 0; i<buttons.length; i++){ //сесть на стул
            if(chatMessage.getContent().equals(buttons[i])){
                gameTable.sitOnChair(i,us.findByName(chatMessage.getSender()));
            }
        }
        return chatMessage;
    }


}

