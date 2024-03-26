package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class TurnInFlatWorldImpl implements CanPlayerDoAction {

  private FlatWorldPlayer[] flatWorldPlayers;
  private boolean[] action;

  @Bean
  public TurnInFlatWorldImpl start(FlatWorldPlayer[] players, FlatWorldPlayer firstTurnPlayer) {
    TurnInFlatWorldImpl t = new TurnInFlatWorldImpl();
    t.flatWorldPlayers = players;
    t.action = new boolean[players.length];
    for(int i = 0; i< flatWorldPlayers.length; i++){
      if(flatWorldPlayers[i].getName().equals(firstTurnPlayer.getName())){
        action[i]=true;
      }
    }
    return t;
  }

  @Override
  public void nextTurn() {
    int turnPlayer = findTurnPlayer();
    action[turnPlayer]=false;
    if(turnPlayer==action.length){
      action[0]=true;
    }else {
      action[turnPlayer+1]=true;
    }
  }

  @Override
  public boolean itIsMyTurn(String player) {
    return flatWorldPlayers[findTurnPlayer()].getName().equals(player);
  }

  private int findTurnPlayer(){
    for(int i = 0; i< action.length; i++){
      if(action[i]){
        return  i;
      }
    }return -1;
  }

}
