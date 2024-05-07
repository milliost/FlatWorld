package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;

public interface LobbyService {
     void sitOnChair(int numOfChair, String player);
     FlatWorldPlayer[] makePlayerArrayForGame();
     String toString();
}
