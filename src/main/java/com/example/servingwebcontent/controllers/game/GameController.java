package com.example.servingwebcontent.controllers.game;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.LobbyService;
import com.example.servingwebcontent.model.games.flatWorld.comandHandler.TextCommandHandler;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

@Component
@AllArgsConstructor
public class GameController {

    private final TextCommandHandler textCommandHandler;

    @MessageMapping("/publicMessage")
    public void publicMessage(@Payload ChatMessage cm) {
        textCommandHandler.acceptCommand(cm);
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ChatMessage greeting(ChatMessage message){
        message.setContent("Hello, " + HtmlUtils.htmlEscape(message.getSender()) + "!");
        return message;
    }
}
