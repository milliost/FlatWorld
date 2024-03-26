package com.example.servingwebcontent.model.games.flatWorld.comandHandler;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.LobbyService;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TextCommandHandler {

    private SimpMessageSendingOperations messagingTemplate;
    private FlatWorldGame flatWorldGame;
    private LobbyService ls;

    public void acceptCommand(ChatMessage chatMessage) {
        switch (chatMessage.getType()){
            case JOIN, LEAVE -> messagingTemplate.convertAndSend(("/topic/public"), chatMessage);
            case SIT -> {
                ls.sitOnChair(
                    Integer.parseInt(chatMessage.getContent().replaceAll("[a-z]","")),
                    chatMessage.getSender());
                chatMessage.setContent(ls.toString());
                messagingTemplate.convertAndSend(("/topic/public"), chatMessage);
            }
            case START->flatWorldGame.start(ls.makePlayerArrayForGame());
        }
    }
}
