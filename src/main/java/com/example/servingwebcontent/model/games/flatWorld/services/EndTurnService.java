package com.example.servingwebcontent.model.games.flatWorld.services;

import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import java.io.IOException;
import org.springframework.stereotype.Component;

public interface EndTurnService {
  void endTurn(FlatWorldPlayer playerWhoEndTurn);

}
