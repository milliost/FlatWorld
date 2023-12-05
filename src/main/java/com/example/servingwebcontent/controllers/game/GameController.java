package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.model.games.flatWorld.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.Game;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@AllArgsConstructor
public class GameController {

    private final Game game;
    private static final Logger logger = LoggerFactory.getLogger(LobbyController.class);

    @MessageMapping("/chat.endTurn")
    @SendTo("/topic/public")
    public ChatMessage endTurn(@Payload ChatMessage chatMessage) {
        game.nextTurn(chatMessage.getSender());
        logger.info(chatMessage.getSender()+" завершил ход");
        return chatMessage;
    }
    @MessageMapping("/chat.playCard")
    @SendTo("/topic/public")
    public ChatMessage playCard(@Payload ChatMessage chatMessage) {

        logger.info(chatMessage.getSender()+" сыграл карту");
        return chatMessage;
    }
}
