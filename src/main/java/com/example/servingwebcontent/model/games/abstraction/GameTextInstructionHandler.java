package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.Instruction;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import com.example.servingwebcontent.model.games.flatWorld.cards.DeckService;
import com.example.servingwebcontent.model.games.flatWorld.map.MapService;
import com.example.servingwebcontent.model.games.flatWorld.services.Dice;
import com.example.servingwebcontent.model.games.flatWorld.services.EndTurnService;
import java.io.IOException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
//превращает инструкции в действия
public class GameTextInstructionHandler {

  private MapService mapService;
  private DeckService deckService;
  private EndTurnService endTurnService;
  private Dice dice;
  public void acceptInstruction(Instruction instruction){
    switch (instruction.getActionEnum()) {
      case SERVITOR -> mapService.addSlave(instruction.getParameter(),instruction.getPlayer());
      case KILL ->mapService.kill(instruction.getParameter(),instruction.getPlayer());
      case DROP -> instruction.getPlayer().dropCard(instruction.getParameter());
      case HOME -> mapService.buyHouse(instruction.getParameter(),instruction.getPlayer());
      case MONEY -> instruction.getPlayer().transferFunds(instruction.getParameter());
      case POLICE -> mapService.removeConflict(instruction.getParameter());
      case CATACLYSME -> deckService.takeCataclysmeCard();
      case PLAYCARD -> instruction.getPlayer().playCard(instruction.getParameter());
      case NEXTCARD -> instruction.getPlayer().addWhatCanPlayerDo(ActionEnum.PLAYCARD);
      case ENDTURN -> endTurnService.endTurn(instruction.getPlayer());
      case DICE -> dice.RollTheDice();
    }
  }
}
