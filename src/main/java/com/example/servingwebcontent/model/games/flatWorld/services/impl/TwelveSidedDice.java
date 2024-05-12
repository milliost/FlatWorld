package com.example.servingwebcontent.model.games.flatWorld.services.impl;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.abstraction.ChatMessage.MessageType;
import com.example.servingwebcontent.model.games.flatWorld.services.Dice;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TwelveSidedDice implements Dice {

  private SimpMessageSendingOperations messagingTemplate;

  @Override
  public int RollTheDice() {
    int random = (int) (Math.random() * 12) + 1;
    ChatMessage cm = new ChatMessage(MessageType.CHAT, "было выброшенно значение " + random,
        "server");
    messagingTemplate.convertAndSend(("/topic/public"), cm);
    return random;
  }
}
