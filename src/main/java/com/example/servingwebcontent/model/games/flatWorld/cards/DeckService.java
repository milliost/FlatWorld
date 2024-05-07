package com.example.servingwebcontent.model.games.flatWorld.cards;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;


public interface DeckService {
  void getCardsUpToPlayerMax(FlatWorldPlayer player);
  String takeCataclysmeCard();
  Deck getDeck();

}
