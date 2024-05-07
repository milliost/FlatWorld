package com.example.servingwebcontent.model.games.flatWorld.cards;

public class BrownCard extends Card {

  private final CardColor cardColor = CardColor.BROWN;

  public BrownCard(String name, ActionEnum... actionEnums) {
    super(name, actionEnums);
  }

  public BrownCard(String name, int money, ActionEnum... actionEnums) {
    super(name, money, actionEnums);
  }
}
