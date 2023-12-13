package com.example.servingwebcontent.model.games.flatWorld.flatWorldService;

import com.example.servingwebcontent.model.games.flatWorld.Player;

public interface Turn {
    void nextTurn();
    boolean itIsMyTurn(String player);
}
