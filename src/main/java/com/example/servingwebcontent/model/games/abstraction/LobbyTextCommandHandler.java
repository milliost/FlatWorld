package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.Instruction;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
public class LobbyTextCommandHandler {

  private SimpMessageSendingOperations messagingTemplate;
  private FlatWorldGame flatWorldGame;
  private LobbyService ls;
  private GameTextInstructionHandler gameTextInstructionHandler;
  private Logger logger;

  public LobbyTextCommandHandler(SimpMessageSendingOperations messagingTemplate,
      FlatWorldGame flatWorldGame, LobbyService ls,
      GameTextInstructionHandler gameTextInstructionHandler) {
    this.messagingTemplate = messagingTemplate;
    this.flatWorldGame = flatWorldGame;
    this.ls = ls;
    this.gameTextInstructionHandler = gameTextInstructionHandler;
    this.logger = LoggerFactory.getLogger(LobbyTextCommandHandler.class);
  }

  public void acceptCommand(ChatMessage cm){

    logger.info(String.valueOf(cm));

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
      case LOBBY -> {
        cm.setContent(ls.toString());
        messagingTemplate.convertAndSend(("/topic/public"), cm);
        logger.info(ls.toString());
      }
      case INSTRUCTION -> gameTextInstructionHandler.acceptInstruction(
          new Instruction(
              ActionEnum.valueOf(cm.getActionEnum()),
              cm.getParameter(),
              flatWorldGame.findPlayer(cm.getInstructionPlayer())));

    }
  }
}
