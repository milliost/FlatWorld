package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.Instruction;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LobbyTextCommandHandler {

  private SimpMessageSendingOperations messagingTemplate;
  private FlatWorldGame flatWorldGame;
  private LobbyService ls;
  private GameTextInstructionHandler gameTextInstructionHandler;

  public void acceptCommand(ChatMessage cm) {
    switch (cm.getType()) {
      case CHAT, JOIN, LEAVE -> messagingTemplate.convertAndSend(("/topic/public"), cm);
      case SIT -> {
        ls.sitOnChair(
            Integer.parseInt(cm.getContent()) - 1,
            cm.getSender());
        messagingTemplate.convertAndSend(("/topic/public"), cm);
      }
      case START -> {
        flatWorldGame.start(ls.makePlayerArrayForGame());
        cm.setContent(cm.getContent() + " начал игру");
        messagingTemplate.convertAndSend(("/topic/public"), cm);
      }
      case INSTRUCTION -> gameTextInstructionHandler.acceptInstruction(
          new Instruction(
              ActionEnum.valueOf(cm.getActionEnum()),
              cm.getParameter(),
              flatWorldGame.findPlayer(cm.getInstructionPlayer())));
    }
  }
}
