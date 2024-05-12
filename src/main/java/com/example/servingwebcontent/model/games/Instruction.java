package com.example.servingwebcontent.model.games;

import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//инструкции передаются с сообщением для взаимодействия с игрой
public class Instruction {

  private ActionEnum actionEnum;
  private int parameter;
  private FlatWorldPlayer player;


  public Instruction(ActionEnum actionEnum) {
    this.actionEnum = actionEnum;
  }

  public Instruction(ActionEnum actionEnum, int parameter, FlatWorldPlayer player) {
    this.actionEnum = actionEnum;
    this.parameter = parameter;
    this.player = player;
  }
}
