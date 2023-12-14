package com.example.servingwebcontent.model.games.flatWorld.flatWorldService;

public interface CanPlayerDoAction {
    void nextTurn();
    boolean itIsMyTurn(String player);
}
