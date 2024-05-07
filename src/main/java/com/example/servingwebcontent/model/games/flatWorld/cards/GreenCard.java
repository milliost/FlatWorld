package com.example.servingwebcontent.model.games.flatWorld.cards;

public class GreenCard extends Card {

  private CardColor cardColor = CardColor.GREEN;

  public GreenCard(String name, ActionEnum... actionEnums) {
    super(name, actionEnums);
  }

  public GreenCard(String name, int money, ActionEnum... actionEnums) {
    super(name, money, actionEnums);
  }

}
