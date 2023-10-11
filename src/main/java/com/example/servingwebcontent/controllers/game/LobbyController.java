package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.entity.User;
import com.example.servingwebcontent.model.ChatMessage;
import com.example.servingwebcontent.model.Game;
import com.example.servingwebcontent.model.Lobby;
import com.example.servingwebcontent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class LobbyController {
    private UserService us;
    private Lobby gameTable;

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
    public ChatMessage addUser(@Payload ChatMessage chatMessage) {

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

    @MessageMapping("/chat.start")
    @SendTo("/topic/public")
    public ChatMessage start(@Payload ChatMessage chatMessage) throws InterruptedException {
        Game game = new Game(gameTable.makeUserArrayForGame());
        game.start();
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




