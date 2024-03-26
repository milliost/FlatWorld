package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldPlayer;

public interface LobbyService {
     void sitOnChair(int numOfChair, String player);
     FlatWorldPlayer[] makePlayerArrayForGame();
     String toString();
}
