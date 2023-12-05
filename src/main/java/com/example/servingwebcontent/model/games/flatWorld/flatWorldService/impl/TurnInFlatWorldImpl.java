package com.example.servingwebcontent.model.games.flatWorld.flatWorldService.impl;

import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.Turn;

public class TurnInFlatWorldImpl implements Turn {
    private int numOfPlayers;
    private boolean[] turn;

    public TurnInFlatWorldImpl(int numOfPlayers, int firstPlayer){
        this.numOfPlayers=numOfPlayers;
        turn = new boolean[numOfPlayers];
        firstTurnPlayer(firstPlayer);
    }

    @Override
    public void nextTurn() {
        for (int i = 0; i<numOfPlayers; i++){
            if(turn[i] ) {
                turn[i]=false;
                if(i==numOfPlayers-1){
                    turn[0]=true;
                    break;
                }else {
                    turn[i + 1] = true;
                    break;
                }
            }
        }
    }

    @Override
    public boolean itIsMyTurn(int numOfPlayer) {
        if(numOfPlayer!=-1){
            return turn[numOfPlayer];
        }else return false;
    }

    private void firstTurnPlayer(int firstPlayer){
        turn[firstPlayer] = true;
    }
}
