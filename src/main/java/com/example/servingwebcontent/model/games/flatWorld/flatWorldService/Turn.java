package com.example.servingwebcontent.model.games.flatWorld.flatWorldService;

public interface Turn {
    void nextTurn();
    boolean itIsMyTurn(int numOfPlayer);
}
