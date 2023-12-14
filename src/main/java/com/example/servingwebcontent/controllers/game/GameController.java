package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.model.games.flatWorld.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.comandHandler.TextCommandHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

public class GameController {
    private final TextCommandHandler textCommandHandler;
    public GameController(TextCommandHandler textCommandHandler){
        this.textCommandHandler = textCommandHandler;
    }

    @MessageMapping("/chat.publicMessage")
    public void publicMessage(@Payload ChatMessage chatMessage) {
        textCommandHandler.acceptCommand(chatMessage);
    }
}
