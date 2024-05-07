package com.example.servingwebcontent.model.games.flatWorld.cards;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import org.springframework.stereotype.Component;

@Component
public interface DeckService {
  void getCardsUpToPlayerMax(FlatWorldPlayer player);
  String takeCataclysmeCard();

}
