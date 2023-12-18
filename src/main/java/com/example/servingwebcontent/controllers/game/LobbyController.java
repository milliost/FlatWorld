package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.comandHandler.TextCommandHandler;
import com.example.servingwebcontent.model.games.abstraction.LobbyService;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl.FlatWorldLobbyImpl;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

@AllArgsConstructor
@Controller
@RequestScope
public class LobbyController {

    private LobbyService ls;

    @ResponseBody
    @GetMapping("/history")
    public String kek() {
        return ls.toString();
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage) {
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        chatMessage.setContent(": подключился к игре");
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
        FlatWorldGame flatWorldGame = new FlatWorldGame(ls.makePlayerArrayForGame());
        new GameController(new TextCommandHandler(flatWorldGame));
        chatMessage.setContent(chatMessage.getSender() + "начал игру");
        return chatMessage;
    }
    @MessageMapping("/chat.sit")
    @SendTo("/topic/public")
    public ChatMessage sit(@Payload ChatMessage chatMessage) {
        String callingPlayer = chatMessage.getSender();
        int numOfChair = Integer.parseInt(chatMessage.getContent().replaceAll("[a-z]",""));
        ls.sitOnChair(numOfChair, callingPlayer);

        return history();
    }
}




