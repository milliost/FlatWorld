package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.flatWorld.Player;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.Turn;
import java.util.Hashtable;
import java.util.Map;

public class TurnInFlatWorldImpl implements Turn {
    private Map<Player, Boolean> turn;
    private Player[] players;

    public TurnInFlatWorldImpl(Player[] players, Player firstPlayer){
        this.players = players;
        turn = new Hashtable<>();
        for (Player player : players) {
            turn.put(player, false);
        }
        turn.put(firstPlayer,true);
    }

    @Override
    public void nextTurn() {
        for (int i = 0; i< players.length; i++){
            if(turn.get(players[i])) {
                turn.put(players[i],false);
                if(i==players.length-1){
                    turn.put(players[0],true);
                    break;
                }else {
                    turn.put(players[i + 1],true);
                    break;
                }
            }
        }
    }

    @Override
    public boolean itIsMyTurn(String userName) {
        for (Player player : players) {
            if (player.getName().equals(userName) && turn.get(player)) return true;
        }
        return false;
    }
}
