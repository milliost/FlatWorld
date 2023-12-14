package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;
import java.util.Hashtable;
import java.util.Map;

public class TurnInFlatWorldImpl implements CanPlayerDoAction {
    private Map<FlatWorldPlayer, Boolean> turn;
    private FlatWorldPlayer[] flatWorldPlayers;

    public TurnInFlatWorldImpl(FlatWorldPlayer[] flatWorldPlayers, FlatWorldPlayer firstFlatWorldPlayer){
        this.flatWorldPlayers = flatWorldPlayers;
        turn = new Hashtable<>();
        for (FlatWorldPlayer flatWorldPlayer : flatWorldPlayers) {
            turn.put(flatWorldPlayer, false);
        }
        turn.put(firstFlatWorldPlayer,true);
    }

    @Override
    public void nextTurn() {
        for (int i = 0; i< flatWorldPlayers.length; i++){
            if(turn.get(flatWorldPlayers[i])) {
                turn.put(flatWorldPlayers[i],false);
                if(i== flatWorldPlayers.length-1){
                    turn.put(flatWorldPlayers[0],true);
                    break;
                }else {
                    turn.put(flatWorldPlayers[i + 1],true);
                    break;
                }
            }
        }
    }

    @Override
    public boolean itIsMyTurn(String userName) {
        for (FlatWorldPlayer flatWorldPlayer : flatWorldPlayers) {
            if (flatWorldPlayer.getName().equals(userName) && turn.get(flatWorldPlayer)) return true;
        }
        return false;
    }
}
