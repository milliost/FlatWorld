package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.LobbyTextCommandHandler;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ChatController {

    private final LobbyTextCommandHandler lobbyTextCommandHandler;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage){
        lobbyTextCommandHandler.acceptCommand(chatMessage);
    }
}




