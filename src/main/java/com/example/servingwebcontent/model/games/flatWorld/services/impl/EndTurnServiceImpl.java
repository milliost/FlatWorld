package com.example.servingwebcontent.model.games.flatWorld.services.impl;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import com.example.servingwebcontent.model.games.flatWorld.cards.DeckService;
import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.services.EndTurnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EndTurnServiceImpl implements EndTurnService {

  private FlatWorldGame flatWorldGame;
  private DeckService deckService;

  @Override
  public void endTurn(FlatWorldPlayer playerWhoEndTurn) {
    for (int i = 0; i < flatWorldGame.getPlayers().length; i++) {
      if (flatWorldGame.getPlayers()[i] == playerWhoEndTurn) {
        if (i == flatWorldGame.getPlayers().length - 1){
          flatWorldGame.getPlayers()[0].addWhatCanPlayerDo(ActionEnum.PLAYCARD);
        }else{
          flatWorldGame.getPlayers()[i+1].addWhatCanPlayerDo(ActionEnum.PLAYCARD);
        }
      }
    }
    deckService.getCardsUpToPlayerMax(playerWhoEndTurn);
    playerWhoEndTurn.setWhatCanPlayerDoToNothing();
  }
}
