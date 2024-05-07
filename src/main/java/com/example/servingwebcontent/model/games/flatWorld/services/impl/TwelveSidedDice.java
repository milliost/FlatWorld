package com.example.servingwebcontent.model.games.flatWorld.services.impl;

import com.example.servingwebcontent.model.games.flatWorld.services.Dice;

public class TwelveSidedDice implements Dice {

  @Override
  public int RollTheDice() {

    return (int) (Math.random() * 12) + 1;
  }
}
