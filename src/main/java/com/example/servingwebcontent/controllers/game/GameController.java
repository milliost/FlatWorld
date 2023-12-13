package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.model.games.flatWorld.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.comandHandler.TextCommandHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

public class GameController {
    private final TextCommandHandler textCommandHandler;
    public GameController(TextCommandHandler textCommandHandler){
        this.textCommandHandler = textCommandHandler;
    }

    @MessageMapping("/chat.publicMessage")
    @SendTo("/topic/public")
    public ChatMessage publicMessage(@Payload ChatMessage chatMessage) {
        return textCommandHandler.acceptCommand(chatMessage);
    }
    @MessageMapping("/chat.privateMessage")
    public void privateMessage(@Payload ChatMessage chatMessage) {

    }
}
