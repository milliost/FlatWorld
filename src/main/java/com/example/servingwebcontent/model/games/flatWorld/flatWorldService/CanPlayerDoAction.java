package com.example.servingwebcontent.model.games.flatWorld.flatWorldService;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;
import org.springframework.stereotype.Component;

@Component
public interface CanPlayerDoAction {
    CanPlayerDoAction start(FlatWorldPlayer[] players, FlatWorldPlayer firstTurnPlayer);
    void nextTurn();
    boolean itIsMyTurn(String player);
}
